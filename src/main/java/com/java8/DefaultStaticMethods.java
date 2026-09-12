package com.java8;

public class DefaultStaticMethods {

    interface ShippingPolicy {
        double charge(double orderAmount);

        default boolean isFree(double orderAmount) {
            return orderAmount >= freeThreshold();
        }

        static double freeThreshold() {
            return 999;
        }
    }

    static final class MetroShipping implements ShippingPolicy {
        @Override
        public double charge(double orderAmount) {
            return isFree(orderAmount) ? 0 : 49;
        }
    }

    static final class RemoteShipping implements ShippingPolicy {
        @Override
        public double charge(double orderAmount) {
            return isFree(orderAmount) ? 0 : 99;
        }
    }

    public static void main(String[] args) {
        ShippingPolicy pune = new MetroShipping();
        ShippingPolicy leh = new RemoteShipping();

        System.out.println("Free shipping starts at ₹" + ShippingPolicy.freeThreshold());
        System.out.println("Pune on ₹800 cart: ₹" + pune.charge(800));
        System.out.println("Leh on ₹1500 cart: ₹" + leh.charge(1500));
    }
}
