package com.java21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SequencedCollection;
import java.util.SequencedMap;
import java.util.random.RandomGenerator;

public class CollectionsSequenced {

    public static void main(String[] args) {
        List<String> flashSale = new ArrayList<>(List.of("SKU-1", "SKU-2", "SKU-3"));
        Collections.shuffle(flashSale, RandomGenerator.getDefault());

        SequencedCollection<String> frozenOrder = Collections.unmodifiableSequencedCollection(flashSale);
        SequencedMap<String, Boolean> seen = new LinkedHashMap<>();
        var uniqueSkus = Collections.newSequencedSetFromMap(seen);
        uniqueSkus.add("SKU-1");
        uniqueSkus.add("SKU-1");

        SequencedMap<String, String> frozenTouch = Collections.unmodifiableSequencedMap(
                new LinkedHashMap<>(Map.of("C-1", "viewed"))
        );

        System.out.println("Shuffled flash SKUs: " + frozenOrder);
        System.out.println("Unique flash SKUs: " + uniqueSkus);
        System.out.println("Frozen first event: " + frozenTouch.firstEntry());
    }
}
