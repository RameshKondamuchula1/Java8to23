package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ObjectsApi {

    public static void main(String[] args) {
        List<String> emails = Arrays.asList("asha@retail.com", null, "ops@retail.com");

        List<String> reachable = emails.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        long missing = emails.stream().filter(Objects::isNull).count();

        String sku = Objects.requireNonNull("SKU-100", () -> "sku missing on checkout " + System.nanoTime());

        System.out.println("Invoice emails: " + reachable);
        System.out.println("Null slots dropped: " + missing);
        System.out.println("Validated SKU: " + sku);
    }
}
