package com.java9;

public class PrivateInterfaceMethods {

    interface DiscountPolicy {
        default double festivePrice(double mrp) {
            return apply(mrp, 0.20);
        }

        default double loyaltyPrice(double mrp, int ordersThisYear) {
            double extra = ordersThisYear >= 10 ? 0.05 : 0;
            return apply(mrp, 0.10 + extra);
        }

        private double apply(double mrp, double rate) {
            return Math.round(mrp * (1 - rate));
        }
    }

    static final class RetailDiscount implements DiscountPolicy {
    }

    public static void main(String[] args) {
        DiscountPolicy policy = new RetailDiscount();
        System.out.println("Festive price of ₹1999: ₹" + policy.festivePrice(1999));
        System.out.println("Loyal customer price: ₹" + policy.loyaltyPrice(1999, 12));
    }
}
