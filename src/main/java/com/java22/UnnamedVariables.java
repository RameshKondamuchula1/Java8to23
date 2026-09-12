package com.java22;

import java.util.List;

public class UnnamedVariables {

    record Card(double amount, String last4) {
    }

    record Upi(double amount, String vpa) {
    }

    static String mask(Object payment) {
        return switch (payment) {
            case Card(_, String last4) -> "****" + last4;
            case Upi(_, String vpa) -> vpa;
            default -> "unknown";
        };
    }

    public static void main(String[] args) {
        var items = List.of("SKU-1", "SKU-2", "SKU-3");
        int skuCount = 0;
        for (var _ : items) {
            skuCount++;
        }

        try {
            Integer.parseInt("FREE");
        } catch (NumberFormatException _) {
            System.out.println("Coupon is not numeric — treat as promo code.");
        }

        System.out.println("Lines in cart: " + skuCount);
        System.out.println("Masked card: " + mask(new Card(2499, "4412")));
    }
}
