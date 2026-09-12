package com.java16;

import java.util.Objects;

public class ObjectsLongIndex {

    public static void main(String[] args) {
        long offset = Objects.checkIndex(4L, 10L);
        long from = Objects.checkFromToIndex(2L, 6L, 10L);
        long sized = Objects.checkFromIndexSize(3L, 4L, 10L);
        System.out.println("Byte-range checks passed: " + offset + ", " + from + ", " + sized);
    }
}
