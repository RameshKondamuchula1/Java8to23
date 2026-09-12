package com.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectorsMore {

    static final class Order {
        final String city;
        final double amount;

        Order(String city, double amount) {
            this.city = city;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("Pune", 12000),
                new Order("Pune", 8000),
                new Order("Mumbai", 15000)
        );

        long n = orders.stream().collect(Collectors.counting());
        double sum = orders.stream().collect(Collectors.summingDouble(o -> o.amount));
        double avg = orders.stream().collect(Collectors.averagingDouble(o -> o.amount));
        Optional<Order> max = orders.stream().collect(Collectors.maxBy(Comparator.comparingDouble(o -> o.amount)));
        Optional<Order> min = orders.stream().collect(Collectors.minBy(Comparator.comparingDouble(o -> o.amount)));

        LinkedList<String> cities = orders.stream()
                .map(o -> o.city)
                .collect(Collectors.toCollection(LinkedList::new));

        Map<String, Double> cityGmv = orders.stream().collect(Collectors.toMap(
                o -> o.city,
                o -> o.amount,
                Double::sum
        ));

        Map<String, Double> mapped = orders.stream().collect(Collectors.groupingBy(
                o -> o.city,
                Collectors.mapping(o -> o.amount, Collectors.reducing(0.0, Double::sum))
        ));

        String unmodifiableView = orders.stream()
                .map(o -> o.city)
                .distinct()
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> String.join("/", list)));

        System.out.println("counting/sum/avg: " + n + " / ₹" + sum + " / ₹" + avg);
        System.out.println("minBy/maxBy: ₹" + min.get().amount + " / ₹" + max.get().amount);
        System.out.println("toCollection: " + cities);
        System.out.println("toMap merge: " + cityGmv);
        System.out.println("mapping+reducing: " + mapped);
        System.out.println("collectingAndThen: " + unmodifiableView);
    }
}
