package com.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorApi {

    static final class Product {
        final String name;
        final String category;
        final Double rating;

        Product(String name, String category, Double rating) {
            this.name = name;
            this.category = category;
            this.rating = rating;
        }

        @Override
        public String toString() {
            return name + "/" + category + "/" + rating;
        }
    }

    public static void main(String[] args) {
        List<Product> catalog = Arrays.asList(
                new Product("Mouse", "Electronics", 4.6),
                new Product("Desk", "Furniture", null),
                new Product("Laptop", "Electronics", 4.8)
        );

        catalog.sort(Comparator
                .comparing((Product p) -> p.category)
                .thenComparing(p -> p.rating, Comparator.nullsLast(Comparator.reverseOrder())));

        System.out.println("PDP sort (category, then rating): " + catalog);
    }
}
