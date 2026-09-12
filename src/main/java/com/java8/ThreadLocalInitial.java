package com.java8;

public class ThreadLocalInitial {

    static final ThreadLocal<String> TENANT = ThreadLocal.withInitial(() -> "guest");

    public static void main(String[] args) {
        System.out.println("Before login: " + TENANT.get());
        TENANT.set("retail-in");
        System.out.println("After login: " + TENANT.get());
        TENANT.remove();
        System.out.println("After logout (re-initialized): " + TENANT.get());
    }
}
