package com.java12;

public class StringIndentTransform {

    public static void main(String[] args) {
        String rawSku = " sku-100 ";

        String normalized = rawSku.transform(s -> s.strip().toUpperCase());
        String receipt = "Item: Wireless Mouse\nQty: 1\n".indent(2);

        System.out.println("Catalog key: " + normalized);
        System.out.println("Receipt block:\n" + receipt);
    }
}
