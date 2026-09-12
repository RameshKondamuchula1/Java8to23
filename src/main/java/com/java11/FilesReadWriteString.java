package com.java11;

import java.nio.file.Files;
import java.nio.file.Path;

public class FilesReadWriteString {

    public static void main(String[] args) throws Exception {
        Path policy = Files.createTempFile("return-policy", ".txt");
        Files.writeString(policy, "Returns accepted within 7 days for unused items.");

        String loaded = Files.readString(policy);
        System.out.println("Help-center article: " + loaded);
        Files.deleteIfExists(policy);
    }
}
