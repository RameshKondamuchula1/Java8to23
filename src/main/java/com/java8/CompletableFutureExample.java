package com.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {

    static String fetchInventory(String sku) {
        sleep(120);
        return sku + ": 14 units";
    }

    static String fetchPrice(String sku) {
        sleep(80);
        return sku + ": ₹2499";
    }

    static String buildOffer(String inventory, String price) {
        return "PDP ready → " + inventory + " | " + price;
    }

    public static void main(String[] args) throws Exception {
        String sku = "SKU-8891";

        CompletableFuture<String> inventory = CompletableFuture.supplyAsync(() -> fetchInventory(sku));
        CompletableFuture<String> price = CompletableFuture.supplyAsync(() -> fetchPrice(sku));

        String pdp = inventory.thenCombine(price, CompletableFutureExample::buildOffer)
                .orTimeout(1, TimeUnit.SECONDS)
                .exceptionally(ex -> "PDP fallback for " + sku)
                .get();

        System.out.println(pdp);
    }

    static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
