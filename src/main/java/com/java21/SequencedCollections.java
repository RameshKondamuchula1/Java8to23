package com.java21;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.SequencedMap;

public class SequencedCollections {

    public static void main(String[] args) {
        List<String> recentOrders = new ArrayList<>(List.of("O-1", "O-2", "O-3"));
        recentOrders.addFirst("O-0");
        recentOrders.addLast("O-4");

        SequencedMap<String, String> lastTouch = new LinkedHashMap<>();
        lastTouch.putLast("C-100", "viewed PDP");
        lastTouch.putLast("C-200", "added to cart");
        lastTouch.putFirst("C-001", "opened app");

        System.out.println("Oldest order: " + recentOrders.getFirst());
        System.out.println("Newest order: " + recentOrders.getLast());
        System.out.println("Newest first: " + recentOrders.reversed());
        System.out.println("Cancel oldest: " + recentOrders.removeFirst());
        System.out.println("First customer event: " + lastTouch.firstEntry());
        System.out.println("Latest customer event: " + lastTouch.lastEntry());
        System.out.println("Drop first event: " + lastTouch.pollFirstEntry());
    }
}
