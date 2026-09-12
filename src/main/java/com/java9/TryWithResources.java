package com.java9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class TryWithResources {

    public static void main(String[] args) throws IOException {
        BufferedReader csv = new BufferedReader(new StringReader("ORDER-1,PAID\nORDER-2,REFUND"));

        try (csv) {
            String first = csv.readLine();
            System.out.println("First settlement row: " + first);
        }
    }
}
