package com.java8;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsExample {

    static final class Order {
        final String city;
        final String channel;
        final double amount;

        Order(String city, String channel, double amount) {
            this.city = city;
            this.channel = channel;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("Pune", "APP", 12000),
                new Order("Pune", "WEB", 8000),
                new Order("Mumbai", "APP", 15000),
                new Order("Delhi", "WEB", 5000)
        );

        Map<String, Double> revenueByCity = orders.stream()
                .collect(Collectors.groupingBy(o -> o.city, Collectors.summingDouble(o -> o.amount)));

        Map<Boolean, List<Order>> appVsOthers = orders.stream()
                .collect(Collectors.partitioningBy(o -> "APP".equals(o.channel)));

        DoubleSummaryStatistics stats = orders.stream()
                .collect(Collectors.summarizingDouble(o -> o.amount));

        String cities = orders.stream()
                .map(o -> o.city)
                .distinct()
                .collect(Collectors.joining(", "));

        System.out.println("Revenue by city: " + revenueByCity);
        System.out.println("App orders: " + appVsOthers.get(true).size());
        System.out.println("Avg order value: ₹" + stats.getAverage());
        System.out.println("Cities served: " + cities);
    }
}
