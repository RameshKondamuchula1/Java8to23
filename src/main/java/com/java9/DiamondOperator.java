package com.java9;

import java.util.ArrayList;
import java.util.List;

public class DiamondOperator {

    public static void main(String[] args) {
        List<String> pickQueue = new ArrayList<>() {
            @Override
            public boolean add(String sku) {
                System.out.println("Queued for picker: " + sku);
                return super.add(sku);
            }
        };

        pickQueue.add("SKU-100");
        pickQueue.add("SKU-200");
        System.out.println("Pick queue size: " + pickQueue.size());
    }
}
