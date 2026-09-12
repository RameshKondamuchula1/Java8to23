package com.java21;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VirtualThreads {

    static String reserveInventory(String sku) throws InterruptedException {
        Thread.sleep(80);
        return sku + " reserved";
    }

    static String authorizePayment(String orderId) throws InterruptedException {
        Thread.sleep(80);
        return orderId + " paid";
    }

    public static void main(String[] args) throws Exception {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            Future<String> stock = executor.submit(() -> reserveInventory("SKU-100"));
            Future<String> pay = executor.submit(() -> authorizePayment("O-441"));
            Future<Boolean> virtual = executor.submit(() -> Thread.currentThread().isVirtual());

            System.out.println(stock.get() + " | " + pay.get());
            System.out.println("Worker is virtual: " + virtual.get());
        }
    }
}
