package com.java26;

import java.util.concurrent.StructuredTaskScope;

public class StructuredConcurrency {

    static String reserveInventory(String sku) throws InterruptedException {
        Thread.sleep(80);
        return sku + " reserved";
    }

    static String authorizePayment(String orderId) throws InterruptedException {
        Thread.sleep(80);
        return orderId + " paid";
    }

    public static void main(String[] args) throws Exception {
        try (var scope = StructuredTaskScope.open()) {
            var stock = scope.fork(() -> reserveInventory("SKU-100"));
            var pay = scope.fork(() -> authorizePayment("O-441"));
            scope.join();
            System.out.println(stock.get() + " | " + pay.get());
        }

        try (var race = StructuredTaskScope.open(StructuredTaskScope.Joiner.<String>anySuccessfulOrThrow())) {
            race.fork(() -> quoteFrom("primary-warehouse"));
            race.fork(() -> quoteFrom("backup-warehouse"));
            System.out.println("First quote wins: " + race.join());
        }
    }

    static String quoteFrom(String warehouse) throws InterruptedException {
        Thread.sleep(warehouse.startsWith("primary") ? 40 : 90);
        return warehouse + " → 2-day SLA";
    }
}
