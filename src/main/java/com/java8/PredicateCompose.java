package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateCompose {

    public static void main(String[] args) {
        Predicate<String> paid = "PAID"::equals;
        Predicate<String> refund = "REFUNDED"::equals;
        Predicate<String> closed = paid.or(refund);
        Predicate<String> open = closed.negate();

        Function<String, String> city = String::toUpperCase;
        Function<String, String> tag = s -> "HUB-" + s;
        Function<String, String> label = city.andThen(tag);

        List<String> statuses = Arrays.asList("PAID", "OPEN", "REFUNDED");
        System.out.println("Closed tickets: " + statuses.stream().filter(closed).collect(Collectors.toList()));
        System.out.println("Still open: " + statuses.stream().filter(open).collect(Collectors.toList()));
        System.out.println("Warehouse label: " + label.apply("pune"));
    }
}
