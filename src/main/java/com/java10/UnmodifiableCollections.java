package com.java10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UnmodifiableCollections {

    public static void main(String[] args) {
        var incoming = new ArrayList<String>();
        incoming.add("Pune");
        incoming.add("Mumbai");

        var servedCities = List.copyOf(incoming);
        incoming.add("Goa");

        var premiumCities = incoming.stream()
                .filter(city -> city.length() > 4)
                .collect(Collectors.toUnmodifiableList());

        System.out.println("Snapshot given to pricing engine: " + servedCities);
        System.out.println("Live warehouse list: " + incoming);
        System.out.println("Premium cities: " + premiumCities);
    }
}
