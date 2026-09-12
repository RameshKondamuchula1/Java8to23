package com.java19;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class VirtualThreadsPreview {

    public static void main(String[] args) throws Exception {
        var accepted = new AtomicInteger();

        try (var executor = Executors.newThreadPerTaskExecutor(Thread.ofVirtual().factory())) {
            for (int i = 1; i <= 200; i++) {
                int orderId = i;
                executor.submit(() -> {
                    Thread.sleep(20);
                    accepted.incrementAndGet();
                    if (orderId == 1) {
                        System.out.println("Thread type: " + (Thread.currentThread().isVirtual() ? "virtual" : "platform"));
                    }
                    return orderId;
                });
            }
        }

        System.out.println("Checkout requests completed: " + accepted.get());
    }
}
