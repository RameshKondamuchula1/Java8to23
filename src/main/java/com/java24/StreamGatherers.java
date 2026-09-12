package com.java24;

import java.util.List;
import java.util.stream.Gatherers;

public class StreamGatherers {

    public static void main(String[] args) {
        List<Integer> hourlyOrders = List.of(12, 18, 15, 40, 22);

        List<List<Integer>> lastThreeHours = hourlyOrders.stream()
                .gather(Gatherers.windowSliding(3))
                .toList();

        List<Integer> runningGmv = List.of(500, 800, 200).stream()
                .gather(Gatherers.scan(() -> 0, Integer::sum))
                .toList();

        List<List<String>> pickBatches = List.of("SKU-1", "SKU-2", "SKU-3", "SKU-4", "SKU-5")
                .stream()
                .gather(Gatherers.windowFixed(2))
                .toList();

        System.out.println("Sliding demand windows: " + lastThreeHours);
        System.out.println("Running GMV: " + runningGmv);
        System.out.println("Picker batches: " + pickBatches);
    }
}
