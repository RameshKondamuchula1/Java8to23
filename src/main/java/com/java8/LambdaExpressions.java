package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaExpressions {

    static final class Product {
        final String name;
        final double price;
        final String category;

        Product(String name, double price, String category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }

        @Override
        public String toString() {
            return name + " (" + category + ") - ₹" + price;
        }
    }

    public static void main(String[] args) {
        List<Product> catalog = new ArrayList<>(Arrays.asList(
                new Product("Laptop", 72000, "Electronics"),
                new Product("Mouse", 800, "Electronics"),
                new Product("Desk", 12000, "Furniture")
        ));

        catalog.sort((a, b) -> Double.compare(a.price, b.price));
        System.out.println("Cheapest first: " + catalog);

        catalog.removeIf(p -> p.price < 1000);
        System.out.println("After dropping low-value SKUs: " + catalog);

        catalog.forEach(p -> System.out.println("Publish to storefront: " + p.name));
    }
}
