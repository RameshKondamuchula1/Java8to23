package com.java25;

public class FlexibleConstructors {

    static class Account {
        final String holder;

        Account(String holder) {
            this.holder = holder;
        }
    }

    static class LoyaltyAccount extends Account {
        final int points;

        LoyaltyAccount(String holder, int points) {
            if (holder == null || holder.isBlank()) {
                throw new IllegalArgumentException("holder required");
            }
            if (points < 0) {
                throw new IllegalArgumentException("points cannot be negative");
            }
            super(holder.strip());
            this.points = points;
        }
    }

    public static void main(String[] args) {
        var asha = new LoyaltyAccount("  Asha  ", 1200);
        System.out.println(asha.holder + " starts with " + asha.points + " points");

        try {
            new LoyaltyAccount("Ravi", -5);
        } catch (IllegalArgumentException ex) {
            System.out.println("Rejected account: " + ex.getMessage());
        }
    }
}
