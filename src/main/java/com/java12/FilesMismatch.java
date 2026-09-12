package com.java12;

import java.nio.file.Files;
import java.nio.file.Path;

public class FilesMismatch {

    public static void main(String[] args) throws Exception {
        Path original = Files.writeString(Files.createTempFile("invoice-a", ".txt"), "INV-1,₹1200");
        Path reprint = Files.writeString(Files.createTempFile("invoice-b", ".txt"), "INV-1,₹1200");
        Path tampered = Files.writeString(Files.createTempFile("invoice-c", ".txt"), "INV-1,₹2200");

        System.out.println("Reprint matches: " + (Files.mismatch(original, reprint) == -1));
        System.out.println("Tamper offset: " + Files.mismatch(original, tampered));
    }
}
