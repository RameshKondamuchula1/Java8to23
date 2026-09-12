package com.java11;

import java.util.List;
import java.util.stream.Collectors;

public class StringMethods {

    public static void main(String[] args) {
        String rawAddress = "  12 MG Road, Pune  ";
        String couponBlock = "SAVE10\nSAVE10\nFREESHIP";

        System.out.println("Blank coupon? " + "   ".isBlank());
        System.out.println("strip:           [" + rawAddress.strip() + "]");
        System.out.println("stripLeading:    [" + rawAddress.stripLeading() + "]");
        System.out.println("stripTrailing:   [" + rawAddress.stripTrailing() + "]");
        System.out.println("Receipt divider: " + "-".repeat(16));

        List<String> uniqueCoupons = couponBlock.lines()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Coupons to activate: " + uniqueCoupons);
    }
}
