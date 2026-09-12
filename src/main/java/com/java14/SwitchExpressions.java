package com.java14;

public class SwitchExpressions {

    static String warehouseAction(String status) {
        return switch (status) {
            case "PAID" -> "Allocate inventory and print pick-list";
            case "PACKED" -> "Hand over to courier";
            case "CANCELLED", "REFUNDED" -> "Return stock to bin";
            case "ON_HOLD" -> {
                var reason = "Manual fraud review";
                yield "Park in exception queue: " + reason;
            }
            default -> "Ignore — unknown status " + status;
        };
    }

    public static void main(String[] args) {
        System.out.println(warehouseAction("PAID"));
        System.out.println(warehouseAction("ON_HOLD"));
        System.out.println(warehouseAction("REFUNDED"));
    }
}
