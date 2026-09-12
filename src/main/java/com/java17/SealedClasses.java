package com.java17;

public class SealedClasses {

    sealed interface Payment permits Card, Upi, Wallet {
        double amount();
    }

    record Card(double amount, String last4) implements Payment {
    }

    record Upi(double amount, String vpa) implements Payment {
    }

    record Wallet(double amount, String walletId) implements Payment {
    }

    static double gatewayFee(Payment payment) {
        if (payment instanceof Card) {
            return Math.round(payment.amount() * 0.02);
        }
        if (payment instanceof Upi) {
            return 0;
        }
        return 3.0;
    }

    public static void main(String[] args) {
        Payment checkout = new Upi(2499, "asha@okbank");
        System.out.println("Collect ₹" + checkout.amount() + " fee ₹" + gatewayFee(checkout));
        System.out.println("Card fee on ₹2499: ₹" + gatewayFee(new Card(2499, "4412")));
    }
}
