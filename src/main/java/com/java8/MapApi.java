package com.java8;

import java.util.HashMap;
import java.util.Map;

public class MapApi {

    public static void main(String[] args) {
        Map<String, Integer> cart = new HashMap<String, Integer>();
        cart.put("SKU-100", 2);

        cart.putIfAbsent("SKU-200", 1);
        cart.computeIfAbsent("SKU-300", sku -> 1);
        cart.computeIfPresent("SKU-100", (sku, qty) -> qty + 1);
        cart.merge("SKU-200", 2, Integer::sum);
        cart.compute("SKU-300", (sku, qty) -> qty == null ? 1 : qty);

        int giftWrap = cart.getOrDefault("WRAP", 0);
        cart.replace("SKU-300", 1, 3);
        cart.replaceAll((sku, qty) -> qty > 2 ? 2 : qty);
        cart.remove("WRAP", 0);

        System.out.println("Gift-wrap lines: " + giftWrap);
        cart.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println(e.getKey() + " x" + e.getValue()));
        System.out.println("Highest qty first: " + cart.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("empty"));
    }
}
