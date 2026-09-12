package com.java17;

import java.util.HexFormat;

public class HexFormatExample {

    public static void main(String[] args) {
        HexFormat hex = HexFormat.of().withUpperCase();
        byte[] token = {10, 31, 47};

        String fingerprint = hex.formatHex(token);
        byte[] parsed = hex.parseHex(fingerprint);

        System.out.println("Card-token fingerprint: " + fingerprint);
        System.out.println("Round-trip bytes: " + parsed.length);
        System.out.println("Order id as hex: " + hex.toHexDigits(441));
    }
}
