package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTerminal {

    static final class Order {
        final String id;
        final double amount;
        final String status;

        Order(String id, double amount, String status) {
            this.id = id;
            this.amount = amount;
            this.status = status;
        }
    }

    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("O-1", 12000, "PAID"),
                new Order("O-2", 3500, "CANCELLED"),
                new Order("O-3", 22000, "PAID")
        );

        System.out.print("forEach: ");
        orders.stream().forEach(o -> System.out.print(o.id + " "));
        System.out.println();

        System.out.print("forEachOrdered: ");
        orders.parallelStream().forEachOrdered(o -> System.out.print(o.id + " "));
        System.out.println();

        Object[] raw = orders.stream().map(o -> o.id).toArray();
        String[] typed = orders.stream().map(o -> o.id).toArray(String[]::new);

        double total = orders.stream().map(o -> o.amount).reduce(0.0, Double::sum);
        Optional<Double> maybeMax = orders.stream().map(o -> o.amount).reduce(Double::max);
        double paidOnly = orders.stream().reduce(
                0.0,
                (sum, o) -> "PAID".equals(o.status) ? sum + o.amount : sum,
                Double::sum
        );

        List<String> collected = orders.stream().map(o -> o.id).collect(Collectors.toList());
        List<String> mutable = orders.stream().map(o -> o.id)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        Optional<Order> cheapest = orders.stream().min(Comparator.comparingDouble(o -> o.amount));
        Optional<Order> biggest = orders.stream().max(Comparator.comparingDouble(o -> o.amount));

        System.out.println("toArray: " + raw.length + " / " + typed[0]);
        System.out.println("reduce identity: ₹" + total);
        System.out.println("reduce Optional: ₹" + maybeMax.orElse(0.0));
        System.out.println("reduce 3-arg paid GMV: ₹" + paidOnly);
        System.out.println("collect Collector: " + collected);
        System.out.println("collect supplier: " + mutable);
        System.out.println("count: " + orders.stream().count());
        System.out.println("min/max: " + cheapest.get().id + " / " + biggest.get().id);
        System.out.println("any/all/none PAID: "
                + orders.stream().anyMatch(o -> "PAID".equals(o.status)) + "/"
                + orders.stream().allMatch(o -> "PAID".equals(o.status)) + "/"
                + orders.stream().noneMatch(o -> "FAILED".equals(o.status)));
        System.out.println("findFirst: " + orders.stream().findFirst().get().id);
        System.out.println("findAny: " + orders.stream().findAny().get().id);
    }
}
