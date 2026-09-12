package com.java17;

import java.util.Map;

public class MapEntryCopyOf {

    public static void main(String[] args) {
        Map.Entry<String, Integer> live = Map.entry("SKU-100", 4);
        Map.Entry<String, Integer> snapshot = Map.Entry.copyOf(live);

        System.out.println("Pricing snapshot: " + snapshot.getKey() + " x" + snapshot.getValue());
        System.out.println("Unmodifiable copy: " + (snapshot != live));
    }
}
