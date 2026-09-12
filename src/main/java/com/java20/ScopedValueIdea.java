package com.java20;

import java.util.concurrent.Callable;

public class ScopedValueIdea {

    static final ThreadLocal<String> TENANT = new ThreadLocal<>();

    static String priceFor(String sku) {
        return TENANT.get() + " price list → " + sku + " = ₹1999";
    }

    public static void main(String[] args) throws Exception {
        Callable<String> pricing = () -> priceFor("SKU-100");

        TENANT.set("tenant-in");
        try {
            System.out.println(pricing.call());
        } finally {
            TENANT.remove();
        }

        System.out.println("Java 20 scoped values (incubator) aim to replace this ThreadLocal pattern for virtual threads.");
    }
}
