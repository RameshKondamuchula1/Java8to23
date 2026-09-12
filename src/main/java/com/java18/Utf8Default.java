package com.java18;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Utf8Default {

    public static void main(String[] args) throws Exception {
        System.out.println("JVM default charset: " + Charset.defaultCharset());
        System.out.println("Matches UTF-8: " + Charset.defaultCharset().equals(StandardCharsets.UTF_8));

        Path invoice = Files.writeString(Files.createTempFile("invoice", ".txt"), "Amount: ₹1,299");
        String readBack = Files.readString(invoice);
        System.out.println("Invoice file: " + readBack);
    }
}
