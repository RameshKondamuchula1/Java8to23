package com.java9;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsFiltering {

    static final class Order {
        final String city;
        final double amount;

        Order(String city, double amount) {
            this.city = city;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Pune", 12000),
                new Order("Pune", 800),
                new Order("Mumbai", 15000)
        );

        Map<String, List<Double>> largeByCity = orders.stream().collect(Collectors.groupingBy(
                o -> o.city,
                Collectors.filtering(o -> o.amount >= 1000, Collectors.mapping(o -> o.amount, Collectors.toList()))
        ));

        Map<String, List<String>> skuTags = Map.of("SKU-1", List.of("sale", "new")).entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream().collect(Collectors.flatMapping(tag -> List.of(tag, tag.toUpperCase()).stream(), Collectors.toList()))
                ));

        System.out.println("Large orders by city: " + largeByCity);
        System.out.println("Flattened tags: " + skuTags);
    }
}
