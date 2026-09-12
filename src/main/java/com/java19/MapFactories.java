package com.java19;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;

public class MapFactories {

    public static void main(String[] args) {
        var cart = HashMap.<String, Integer>newHashMap(3);
        cart.put("SKU-100", 2);
        cart.put("SKU-200", 1);

        var seenCoupons = HashSet.<String>newHashSet(2);
        seenCoupons.add("SAVE10");

        var lastTouch = LinkedHashMap.<String, String>newLinkedHashMap(2);
        lastTouch.put("C-100", "viewed PDP");

        Locale store = Locale.of("en", "IN");

        System.out.println("Cart buckets reserved: " + cart.size());
        System.out.println("Coupons used: " + seenCoupons);
        System.out.println("Last touch: " + lastTouch);
        System.out.println("Store locale: " + store.toLanguageTag());
    }
}
