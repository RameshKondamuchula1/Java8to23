package com.java21;

public class SwitchPatternMatching {

    sealed interface Payment permits Card, Upi, Wallet {
    }

    record Card(double amount, String last4) implements Payment {
    }

    record Upi(double amount, String vpa) implements Payment {
    }

    record Wallet(double amount, String walletId) implements Payment {
    }

    static String settle(Payment payment) {
        return switch (payment) {
            case Card(double amount, String last4) when amount > 10_000 ->
                    "OTP required for card ****" + last4;
            case Card(double amount, String last4) ->
                    "Charge ₹" + amount + " to ****" + last4;
            case Upi(double amount, String vpa) ->
                    "Collect ₹" + amount + " from " + vpa;
            case Wallet(double amount, String walletId) ->
                    "Debit ₹" + amount + " from wallet " + walletId;
        };
    }

    public static void main(String[] args) {
        System.out.println(settle(new Card(2499, "4412")));
        System.out.println(settle(new Card(15000, "4412")));
        System.out.println(settle(new Upi(799, "asha@okbank")));
    }
}
