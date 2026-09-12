package com.java9;

public class StringChars {

    public static void main(String[] args) {
        String coupon = "SAVE10";

        boolean asciiOnly = coupon.chars().allMatch(ch -> ch < 128);
        long digits = coupon.codePoints().filter(Character::isDigit).count();

        System.out.println("Coupon is ASCII: " + asciiOnly);
        System.out.println("Digits in coupon: " + digits);
    }
}
