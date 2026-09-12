package com.java11;

import java.nio.file.Path;

public class PathOf {

    public static void main(String[] args) {
        Path invoice = Path.of("settlements", "2026-09-12", "INV-441.txt");
        System.out.println("Invoice path: " + invoice);
        System.out.println("File name: " + invoice.getFileName());
    }
}
