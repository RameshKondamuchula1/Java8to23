package com.java21;

public class ThreadBuilders {

    public static void main(String[] args) throws Exception {
        Thread virtual = Thread.ofVirtual().name("checkout-vt").unstarted(() ->
                System.out.println("Virtual checkout thread: " + Thread.currentThread().isVirtual()));
        virtual.start();
        virtual.join();

        Thread platform = Thread.ofPlatform().name("report-cpu").start(() ->
                System.out.println("Platform report thread: " + !Thread.currentThread().isVirtual()));
        platform.join();

        Thread quick = Thread.startVirtualThread(() ->
                System.out.println("Fire-and-forget notify SMS"));
        quick.join();
    }
}
