package com.java8;

import java.util.Arrays;
import java.util.StringJoiner;

public class StringJoin {

    public static void main(String[] args) {
        String cities = String.join(", ", "Pune", "Mumbai", "Delhi");
        String skuCsv = String.join("|", Arrays.asList("SKU-1", "SKU-2", "SKU-3"));

        StringJoiner invoiceIds = new StringJoiner(", ", "[", "]");
        invoiceIds.add("INV-1").add("INV-2").add("INV-3");

        System.out.println("Dispatch cities: " + cities);
        System.out.println("Pick-wave SKUs: " + skuCsv);
        System.out.println("Invoices in this batch: " + invoiceIds);
    }
}
