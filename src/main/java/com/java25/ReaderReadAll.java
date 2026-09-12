package com.java25;

import java.io.StringReader;

public class ReaderReadAll {

    public static void main(String[] args) throws Exception {
        String csv = "INV-1,₹1200\nINV-2,₹800";
        try (StringReader reader = new StringReader(csv)) {
            System.out.println("Whole settlement file:\n" + reader.readAllAsString());
        }
        try (StringReader reader = new StringReader(csv)) {
            System.out.println("As lines: " + reader.readAllLines());
        }
    }
}
