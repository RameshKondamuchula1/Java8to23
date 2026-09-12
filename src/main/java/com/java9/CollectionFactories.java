package com.java9;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionFactories {

    public static void main(String[] args) {
        List<String> warehouseZones = List.of("PUNE-A", "PUNE-B", "DEL-A");
        Set<String> restrictedSkus = Set.of("ALCOHOL-1", "PHARMA-9");
        Map<String, Integer> stock = Map.of(
                "SKU-100", 40,
                "SKU-200", 12
        );
        Map<String, Integer> moreStock = Map.ofEntries(
                Map.entry("SKU-300", 8),
                Map.entry("SKU-400", 3)
        );

        System.out.println("Zones: " + warehouseZones);
        System.out.println("Blocked SKUs: " + restrictedSkus);
        System.out.println("SKU-100 stock: " + stock.get("SKU-100"));
        System.out.println("Extra SKUs: " + moreStock);

        try {
            warehouseZones.add("BLR-A");
        } catch (UnsupportedOperationException ex) {
            System.out.println("List.of() is unmodifiable — expected in production catalogs.");
        }
    }
}
