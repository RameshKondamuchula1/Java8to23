package com.java11;

import java.util.List;

public class CollectionToArray {

    public static void main(String[] args) {
        List<String> hubs = List.of("Pune", "Mumbai", "Delhi");
        String[] routingTable = hubs.toArray(String[]::new);
        System.out.println("Courier routing table size: " + routingTable.length);
        System.out.println("First hub: " + routingTable[0]);
    }
}
