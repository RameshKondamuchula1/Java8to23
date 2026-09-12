package com.java9;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

public class InputStreamTransferTo {

    public static void main(String[] args) throws Exception {
        byte[] invoice = "INV-441,₹1299".getBytes(StandardCharsets.UTF_8);

        try (ByteArrayInputStream in = new ByteArrayInputStream(invoice);
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            in.transferTo(out);
            System.out.println("Copied settlement file: " + out.toString(StandardCharsets.UTF_8));
        }
    }
}
