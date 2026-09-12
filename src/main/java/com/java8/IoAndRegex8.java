package com.java8;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class IoAndRegex8 {

    public static void main(String[] args) throws Exception {
        String csv = "INV-1,PAID\nINV-2,OPEN";
        try (BufferedReader reader = new BufferedReader(new StringReader(csv))) {
            System.out.println("Settlement lines: " + reader.lines().collect(Collectors.toList()));
        }

        java.util.List<String> skus = Pattern.compile("\\s*,\\s*").splitAsStream("SKU-1, SKU-2,SKU-3")
                .collect(Collectors.toList());
        System.out.println("Split pick list: " + skus);
    }
}
