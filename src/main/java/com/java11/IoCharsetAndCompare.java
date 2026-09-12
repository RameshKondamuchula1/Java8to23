package com.java11;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class IoCharsetAndCompare {

    public static void main(String[] args) throws Exception {
        Path file = Files.writeString(Files.createTempFile("invoice", ".txt"), "Amount: ₹1299");
        String text = Files.readString(file);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.writeBytes(text.getBytes(StandardCharsets.UTF_8));

        int order = CharSequence.compare("Pune", "Mumbai");
        long timeoutMs = TimeUnit.MILLISECONDS.convert(Duration.ofSeconds(3));

        System.out.println("Invoice bytes: " + out.size());
        System.out.println("City compare (Pune vs Mumbai): " + order);
        System.out.println("HTTP timeout millis: " + timeoutMs);
        Files.deleteIfExists(file);
    }
}
