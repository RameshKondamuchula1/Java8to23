package com.java9;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamImprovements {

    static final class Txn {
        final String id;
        final String status;
        final double amount;

        Txn(String id, String status, double amount) {
            this.id = id;
            this.status = status;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        List<Txn> ledger = List.of(
                new Txn("T1", "SUCCESS", 500),
                new Txn("T2", "SUCCESS", 900),
                new Txn("T3", "FAILED", 300),
                new Txn("T4", "SUCCESS", 700)
        );

        List<String> openingSuccess = ledger.stream()
                .takeWhile(t -> "SUCCESS".equals(t.status))
                .map(t -> t.id)
                .collect(Collectors.toList());

        List<String> afterFirstFailure = ledger.stream()
                .dropWhile(t -> "SUCCESS".equals(t.status))
                .map(t -> t.id)
                .collect(Collectors.toList());

        List<Integer> nextThreeInvoiceIds = Stream.iterate(1001, id -> id <= 1003, id -> id + 1)
                .collect(Collectors.toList());

        String maybeCoupon = null;
        long couponEvents = Stream.ofNullable(maybeCoupon).count();

        System.out.println("Opening success streak: " + openingSuccess);
        System.out.println("From first failure onward: " + afterFirstFailure);
        System.out.println("Invoice IDs: " + nextThreeInvoiceIds);
        System.out.println("Coupon events published: " + couponEvents);
    }
}
