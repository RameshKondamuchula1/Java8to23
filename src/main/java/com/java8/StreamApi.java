package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {

    static final class Order {
        final String id;
        final String customer;
        final String city;
        final double amount;
        final String status;

        Order(String id, String customer, String city, double amount, String status) {
            this.id = id;
            this.customer = customer;
            this.city = city;
            this.amount = amount;
            this.status = status;
        }
    }

    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("O-1", "Asha", "Pune", 12000, "PAID"),
                new Order("O-2", "Ravi", "Mumbai", 3500, "CANCELLED"),
                new Order("O-3", "Neha", "Pune", 22000, "PAID"),
                new Order("O-4", "Kiran", "Delhi", 8000, "PAID")
        );

        double puneRevenue = orders.stream()
                .filter(o -> "PAID".equals(o.status))
                .filter(o -> "Pune".equals(o.city))
                .mapToDouble(o -> o.amount)
                .sum();

        boolean hasLargeOrder = orders.stream()
                .anyMatch(o -> o.amount > 20000);

        List<String> paidCustomers = orders.stream()
                .filter(o -> "PAID".equals(o.status))
                .map(o -> o.customer)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Pune paid revenue: ₹" + puneRevenue);
        System.out.println("Has order above ₹20,000: " + hasLargeOrder);
        System.out.println("Paid customers: " + paidCustomers);
    }
}
