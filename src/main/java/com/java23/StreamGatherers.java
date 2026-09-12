package com.java23;

import java.util.List;
import java.util.stream.Gatherers;

public class StreamGatherers {

    public static void main(String[] args) {
        List<String> pickList = List.of("SKU-1", "SKU-2", "SKU-3", "SKU-4", "SKU-5");

        List<List<String>> packingBatches = pickList.stream()
                .gather(Gatherers.windowFixed(2))
                .toList();

        String runningTotal = List.of(499, 799, 199).stream()
                .gather(Gatherers.fold(() -> 0, Integer::sum))
                .map(total -> "Cart total ₹" + total)
                .findFirst()
                .orElse("empty cart");

        System.out.println("Picker batches: " + packingBatches);
        System.out.println(runningTotal);
    }
}
