package com.java16;

import java.util.List;
import java.util.stream.Stream;

public class StreamMapMulti {

    record Order(String id, List<String> skus) {
    }

    public static void main(String[] args) {
        List<String> pickUnits = Stream.of(
                        new Order("O-1", List.of("SKU-1", "SKU-2")),
                        new Order("O-2", List.of("SKU-3"))
                )
                .<String>mapMulti((order, downstream) -> {
                    for (String sku : order.skus()) {
                        downstream.accept(order.id() + ":" + sku);
                    }
                })
                .toList();

        int unitCount = Stream.of(
                        new Order("O-1", List.of("SKU-1", "SKU-2")),
                        new Order("O-2", List.of("SKU-3"))
                )
                .mapMultiToInt((order, downstream) -> {
                    for (int i = 0; i < order.skus().size(); i++) {
                        downstream.accept(1);
                    }
                })
                .sum();

        System.out.println("Flattened pick units: " + pickUnits);
        System.out.println("Pick-unit count: " + unitCount);
    }
}
