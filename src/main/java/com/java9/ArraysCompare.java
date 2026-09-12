package com.java9;

import java.util.Arrays;

public class ArraysCompare {

    public static void main(String[] args) {
        int[] warehouseA = {10, 20, 30};
        int[] warehouseB = {10, 25, 30};
        int[] warehouseC = {10, 20, 30};

        System.out.println("Stock files equal: " + Arrays.equals(warehouseA, warehouseC));
        System.out.println("First mismatch index: " + Arrays.mismatch(warehouseA, warehouseB));
        System.out.println("Compare A vs B: " + Arrays.compare(warehouseA, warehouseB));
    }
}
