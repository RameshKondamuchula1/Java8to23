package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CollectionApi {

    public static void main(String[] args) {
        List<String> pickList = new ArrayList<>(Arrays.asList("SKU-2", "SKU-1", "DAMAGED", "SKU-3"));

        pickList.sort(String::compareTo);
        System.out.println("Sorted pick list: " + pickList);

        pickList.replaceAll(sku -> sku.startsWith("SKU") ? sku : "HOLD");
        System.out.println("After warehouse remap: " + pickList);

        pickList.removeIf("HOLD"::equals);
        System.out.println("Ready to pick: " + pickList);

        System.out.print("Notify pickers: ");
        pickList.forEach(sku -> System.out.print(sku + " "));
        System.out.println();

        Iterator<String> remaining = pickList.iterator();
        remaining.next();
        System.out.print("Resume after first bin: ");
        remaining.forEachRemaining(sku -> System.out.print(sku + " "));
        System.out.println();
    }
}
