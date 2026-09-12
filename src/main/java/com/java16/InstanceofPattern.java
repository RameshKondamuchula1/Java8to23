package com.java16;

public class InstanceofPattern {

    static final class Card {
        final String last4;
        Card(String last4) { this.last4 = last4; }
    }

    static final class Upi {
        final String vpa;
        Upi(String vpa) { this.vpa = vpa; }
    }

    static String receipt(Object payment) {
        if (payment instanceof Card card) {
            return "Charged card ****" + card.last4;
        }
        if (payment instanceof Upi upi) {
            return "Collected via UPI " + upi.vpa;
        }
        return "Unknown payment method";
    }

    public static void main(String[] args) {
        System.out.println(receipt(new Card("4412")));
        System.out.println(receipt(new Upi("asha@okbank")));
    }
}
