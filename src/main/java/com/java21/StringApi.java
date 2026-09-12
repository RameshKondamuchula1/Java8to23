package com.java21;

public class StringApi {

    public static void main(String[] args) {
        String tracking = "O-441:::WH-PUNE::OUT";
        String[] parts = tracking.splitWithDelimiters(":+", -1);

        String skuLine = "prefix SKU-100 suffix";
        int skuAt = skuLine.indexOf("SKU", 0, skuLine.length());

        System.out.println("Tracking tokens: " + String.join(" | ", parts));
        System.out.println("SKU starts at index: " + skuAt);
    }
}
