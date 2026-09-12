package com.java12;

import java.util.List;
import java.util.stream.Collectors;

public class CollectorsTeeing {

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
                new Order("Mumbai", 18000),
                new Order("Pune", 7000)
        );

        String report = orders.stream().collect(Collectors.teeing(
                Collectors.summingDouble(o -> o.amount),
                Collectors.counting(),
                (total, count) -> "Daily GMV ₹" + total + " across " + count + " orders"
        ));

        System.out.println(report);
    }
}
