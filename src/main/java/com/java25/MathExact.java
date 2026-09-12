package com.java25;

public class MathExact {

    public static void main(String[] args) {
        int loyaltyPoints = Math.powExact(2, 10);
        long skuCombo = Math.unsignedMultiplyExact(1_000_000, 42);

        System.out.println("Welcome bonus 2^10 points: " + loyaltyPoints);
        System.out.println("Unsigned combo key: " + skuCombo);

        try {
            Math.powExact(1_000_000, 8);
        } catch (ArithmeticException ex) {
            System.out.println("Overflow blocked: " + ex.getClass().getSimpleName());
        }
    }
}
