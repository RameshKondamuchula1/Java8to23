package com.java11;

import java.util.List;
import java.util.function.BiFunction;

public class VarInLambda {

    public static void main(String[] args) {
        List<String> stores = List.of("Pune", "Mumbai");

        stores.forEach((var store) -> System.out.println("Sync inventory → " + store));

        BiFunction<String, Integer, String> label = (var sku, var qty) -> sku + " x" + qty;
        System.out.println(label.apply("SKU-100", 3));
    }
}
