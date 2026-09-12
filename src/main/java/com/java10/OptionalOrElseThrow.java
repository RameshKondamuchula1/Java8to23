package com.java10;

import java.util.Map;
import java.util.Optional;

public class OptionalOrElseThrow {

    private static final Map<String, String> PANTRY = Map.of("SKU-100", "In stock");

    static Optional<String> stockStatus(String sku) {
        return Optional.ofNullable(PANTRY.get(sku));
    }

    public static void main(String[] args) {
        String status = stockStatus("SKU-100").orElseThrow();
        System.out.println("SKU-100: " + status);

        try {
            stockStatus("SKU-404").orElseThrow();
        } catch (Exception ex) {
            System.out.println("Checkout blocked: " + ex.getClass().getSimpleName());
        }
    }
}
