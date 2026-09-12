package com.java9;

import java.util.Objects;

public class ObjectsChecks {

    static String displayName(String nickname, String legalName) {
        return Objects.requireNonNullElse(nickname, legalName);
    }

    static String packingNote(String note) {
        return Objects.requireNonNullElseGet(note, () -> "standard packing");
    }

    public static void main(String[] args) {
        System.out.println("Checkout name: " + displayName(null, "Asha"));
        System.out.println("Carton note: " + packingNote(null));
        System.out.println("Page index 2 of 10 is valid: " + (Objects.checkIndex(2, 10) == 2));
    }
}
