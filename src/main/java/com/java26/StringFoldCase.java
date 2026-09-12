package com.java26;

public class StringFoldCase {

    public static void main(String[] args) {
        String typed = "strasse";
        String catalog = "Straße";

        boolean sameStreet = typed.equalsFoldCase(catalog);
        int sort = typed.compareToFoldCase(catalog);

        System.out.println("Street match with Unicode fold (ß/ss): " + sameStreet);
        System.out.println("Fold-case compare (0 = same): " + sort);
        System.out.println("UNICODE_CASEFOLD_ORDER: "
                + String.UNICODE_CASEFOLD_ORDER.compare("STRASSE", "straße"));
    }
}
