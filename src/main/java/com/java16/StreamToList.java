package com.java16;

import java.util.List;

public class StreamToList {

    record Shipment(String city, String status) {
    }

    public static void main(String[] args) {
        List<Shipment> todays = List.of(
                new Shipment("Pune", "OUT_FOR_DELIVERY"),
                new Shipment("Goa", "DELAYED"),
                new Shipment("Pune", "DELAYED")
        );

        List<String> delayedCities = todays.stream()
                .filter(s -> "DELAYED".equals(s.status()))
                .map(Shipment::city)
                .distinct()
                .toList();

        System.out.println("SMS delay alert cities: " + delayedCities);
    }
}
