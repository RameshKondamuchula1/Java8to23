package com.java26;

import java.util.List;

public class LazyConstants {

    static final LazyConstant<List<String>> TAX_SLABS = LazyConstant.of(() -> {
        System.out.println("Loading GST slabs from config service…");
        return List.of("0%", "5%", "12%", "18%");
    });

    static final List<String> WAREHOUSE_POOL = List.ofLazy(3, index -> {
        System.out.println("Warming warehouse connection #" + index);
        return "WH-" + index;
    });

    public static void main(String[] args) {
        System.out.println("Checkout started — tax config not loaded yet");
        System.out.println("Slabs: " + TAX_SLABS.get());
        System.out.println("Slabs again (no reload): " + TAX_SLABS.get());
        System.out.println("Route via " + WAREHOUSE_POOL.get(1));
        System.out.println("Same warehouse reused: " + WAREHOUSE_POOL.get(1));
    }
}
