package com.java17;

public class SealedReflection {

    sealed interface Payment permits Card, Upi {
    }

    record Card(double amount) implements Payment {
    }

    record Upi(double amount) implements Payment {
    }

    public static void main(String[] args) {
        Class<?> type = Payment.class;
        System.out.println("Payment is sealed: " + type.isSealed());
        System.out.print("Permitted checkout types: ");
        for (Class<?> c : type.getPermittedSubclasses()) {
            System.out.print(c.getSimpleName() + " ");
        }
        System.out.println();
    }
}
