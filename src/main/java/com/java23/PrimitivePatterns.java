package com.java23;

public class PrimitivePatterns {

    static String cartBand(int qty) {
        return switch (qty) {
            case 0 -> "Empty cart — show recommendations";
            case int n when n < 5 -> "Small cart — offer add-on";
            case int n when n < 20 -> "Bulk cart — apply wholesale slab";
            case int n -> "Wholesale enquiry for " + n + " units";
        };
    }

    static String classifyFlag(Object flag) {
        if (flag instanceof int bit && bit == 1) {
            return "COD allowed";
        }
        if (flag instanceof boolean enabled && enabled) {
            return "Express delivery on";
        }
        return "Default checkout";
    }

    public static void main(String[] args) {
        System.out.println(cartBand(0));
        System.out.println(cartBand(3));
        System.out.println(cartBand(12));
        System.out.println(classifyFlag(1));
        System.out.println(classifyFlag(true));
    }
}
