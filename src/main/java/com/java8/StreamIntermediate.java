package com.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamIntermediate {

    static final class Order {
        final String customer;
        final String city;
        final double amount;
        final List<String> skus;

        Order(String customer, String city, double amount, List<String> skus) {
            this.customer = customer;
            this.city = city;
            this.amount = amount;
            this.skus = skus;
        }
    }

    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("Asha", "Pune", 12000, Arrays.asList("SKU-1", "SKU-2")),
                new Order("Ravi", "Mumbai", 3500, Arrays.asList("SKU-3")),
                new Order("Neha", "Pune", 22000, Arrays.asList("SKU-1")),
                new Order("Asha", "Pune", 8000, Arrays.asList("SKU-4"))
        );

        List<String> cities = orders.stream()
                .filter(o -> o.amount >= 8000)
                .map(o -> o.city)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        List<String> byAmount = orders.stream()
                .sorted(Comparator.comparingDouble(o -> -o.amount))
                .map(o -> o.customer)
                .collect(Collectors.toList());

        List<String> pickUnits = orders.stream()
                .flatMap(o -> o.skus.stream())
                .collect(Collectors.toList());

        IntStream qtyMarks = orders.stream().flatMapToInt(o -> IntStream.of(o.skus.size()));
        long skuChars = orders.stream().flatMapToLong(o -> o.skus.stream().mapToLong(String::length)).sum();
        double skuWeights = orders.stream().flatMapToDouble(o -> o.skus.stream().mapToDouble(s -> 0.2)).sum();
        int[] amounts = orders.stream().mapToInt(o -> (int) o.amount).toArray();
        double[] amountsD = orders.stream().mapToDouble(o -> o.amount).toArray();
        long[] amountsL = orders.stream().mapToLong(o -> (long) o.amount).toArray();

        List<String> topTwo = orders.stream()
                .peek(o -> System.out.println("Audit " + o.customer))
                .skip(1)
                .limit(2)
                .map(o -> o.customer)
                .collect(Collectors.toList());

        Stream<String> letters = Stream.of("A", "B").flatMapToInt(s -> s.chars()).mapToObj(ch -> String.valueOf((char) ch));

        System.out.println("High-value cities: " + cities);
        System.out.println("Customers by GMV: " + byAmount);
        System.out.println("Pick units: " + pickUnits);
        System.out.println("SKU lines / chars / weight: " + qtyMarks.sum() + " / " + skuChars + " / " + skuWeights);
        System.out.println("Int/long/double amounts: " + amounts.length + "/" + amountsL.length + "/" + amountsD.length);
        System.out.println("Skip first, take two: " + topTwo);
        System.out.println("flatMapToInt sample: " + letters.collect(Collectors.joining()));
    }
}
