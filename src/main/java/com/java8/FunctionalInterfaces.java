package com.java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {

    static final class Invoice {
        final String number;
        final double amount;
        final String status;

        Invoice(String number, double amount, String status) {
            this.number = number;
            this.amount = amount;
            this.status = status;
        }
    }

    public static void main(String[] args) {
        Invoice invoice = new Invoice("INV-1042", 18500, "UNPAID");

        Predicate<Invoice> overdue = inv -> inv.amount > 10000 && "UNPAID".equals(inv.status);
        Function<Invoice, Double> lateFee = inv -> inv.amount * 0.02;
        Consumer<String> notifyFinance = msg -> System.out.println("Finance desk: " + msg);
        Supplier<String> nextInvoiceNumber = () -> "INV-" + System.currentTimeMillis();

        if (overdue.test(invoice)) {
            double fee = lateFee.apply(invoice);
            notifyFinance.accept(invoice.number + " late fee ₹" + fee);
        }

        System.out.println("Next invoice number: " + nextInvoiceNumber.get());
    }
}
