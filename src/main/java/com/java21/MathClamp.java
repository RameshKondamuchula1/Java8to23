package com.java21;

public class MathClamp {

    public static void main(String[] args) {
        int requestedQty = 80;
        int sellable = Math.clamp(requestedQty, 1, 20);
        double discount = Math.clamp(42.5, 0.0, 30.0);

        System.out.println("Qty after warehouse cap: " + sellable);
        System.out.println("Discount after policy cap: " + discount + "%");
    }
}
