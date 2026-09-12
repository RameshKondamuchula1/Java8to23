package com.java21;

public class StringBuilderRepeat {

    public static void main(String[] args) {
        String receipt = new StringBuilder()
                .append("TOTAL")
                .repeat(".", 12)
                .append("₹2499")
                .toString();

        System.out.println(receipt);
    }
}
