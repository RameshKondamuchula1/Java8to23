package com.java12;

import java.text.NumberFormat;
import java.util.Locale;

public class CompactNumberFormat {

    public static void main(String[] args) {
        NumberFormat dashboard = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        dashboard.setMaximumFractionDigits(1);

        System.out.println("App downloads: " + dashboard.format(12_400));
        System.out.println("Yearly GMV: " + dashboard.format(18_600_000));
    }
}
