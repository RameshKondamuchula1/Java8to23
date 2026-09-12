package com.java8;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class ConcurrentApi {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> views = new ConcurrentHashMap<String, Integer>();
        views.put("SKU-100", 10);
        views.compute("SKU-100", (sku, n) -> n + 1);
        views.computeIfAbsent("SKU-200", sku -> 1);

        LongAdder checkouts = new LongAdder();
        checkouts.add(3);
        checkouts.increment();

        int totalViews = views.reduceValuesToInt(1, Integer::intValue, 0, Integer::sum);
        String hottest = views.search(1, (sku, n) -> n > 10 ? sku : null);

        views.forEach(1, (sku, n) -> System.out.println(sku + " views=" + n));
        System.out.println("Total views: " + totalViews);
        System.out.println("Hottest SKU: " + hottest);
        System.out.println("Checkouts (LongAdder): " + checkouts.sum());
    }
}
