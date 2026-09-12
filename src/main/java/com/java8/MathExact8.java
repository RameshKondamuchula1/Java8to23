package com.java8;

public class MathExact8 {

    public static void main(String[] args) {
        int stock = Math.addExact(40, 12);
        int sold = Math.subtractExact(stock, 5);
        long skuKey = Math.multiplyExact(1_000_000, 42);
        int page = Math.toIntExact(3L);
        int pages = Math.floorDiv(25, 10);
        int leftover = Math.floorMod(25, 10);

        System.out.println("On-hand after inbound: " + sold);
        System.out.println("Composite SKU key: " + skuKey);
        System.out.println("Page " + page + " → " + pages + " full bins, leftover " + leftover);

        try {
            Math.addExact(Integer.MAX_VALUE, 1);
        } catch (ArithmeticException ex) {
            System.out.println("Overflow blocked: " + ex.getClass().getSimpleName());
        }
    }
}
