package com.java8;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Example {

    public static void main(String[] args) {
        byte[] token = "tenant-in:asha".getBytes(StandardCharsets.UTF_8);
        String header = Base64.getEncoder().encodeToString(token);
        String decoded = new String(Base64.getDecoder().decode(header), StandardCharsets.UTF_8);
        String urlSafe = Base64.getUrlEncoder().withoutPadding().encodeToString(token);

        System.out.println("Auth header: " + header);
        System.out.println("Decoded subject: " + decoded);
        System.out.println("URL-safe state param: " + urlSafe);
    }
}
