package com.java8;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FilesApi {

    public static void main(String[] args) throws Exception {
        Path dir = Files.createTempDirectory("invoices");
        Path inv1 = Files.write(dir.resolve("INV-1.txt"), Arrays.asList("Asha", "₹1200"));
        Files.write(dir.resolve("INV-2.txt"), Arrays.asList("Ravi", "₹800"));

        List<String> firstInvoice = Files.readAllLines(inv1);
        try (Stream<String> lines = Files.lines(inv1);
             Stream<Path> listing = Files.list(dir);
             Stream<Path> tree = Files.walk(dir);
             Stream<Path> txt = Files.find(dir, 2, (p, attrs) -> p.toString().endsWith(".txt"))) {
            System.out.println("INV-1 header: " + firstInvoice.get(0));
            System.out.println("INV-1 line count: " + lines.count());
            System.out.println("Files in folder: " + listing.count());
            System.out.println("Walk entries: " + tree.count());
            System.out.println("Find *.txt: " + txt.count());
        }
    }
}
