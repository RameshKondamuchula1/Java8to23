package com.java8;

import java.util.Arrays;

public class ArraysParallel {

    public static void main(String[] args) {
        int[] ranks = {40, 12, 8, 25};
        Arrays.parallelSort(ranks);

        int[] running = {500, 800, 200};
        Arrays.parallelPrefix(running, Integer::sum);

        String[] bins = new String[3];
        Arrays.setAll(bins, i -> "BIN-" + (i + 1));
        Arrays.parallelSetAll(bins, i -> bins[i] + "-Pune");

        System.out.println("Sorted courier ranks: " + Arrays.toString(ranks));
        System.out.println("Running GMV: " + Arrays.toString(running));
        System.out.println("Warehouse bins: " + Arrays.toString(bins));
    }
}
