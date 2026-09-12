package com.java10;

import java.util.ArrayList;
import java.util.Map;

public class LocalVarInference {

    static final class CartItem {
        final String sku;
        final int qty;

        CartItem(String sku, int qty) {
            this.sku = sku;
            this.qty = qty;
        }
    }

    public static void main(String[] args) {
        var cart = new ArrayList<CartItem>();
        cart.add(new CartItem("SKU-100", 2));
        cart.add(new CartItem("SKU-200", 1));

        var qtyBySku = Map.of("SKU-100", 2, "SKU-200", 1);
        var totalUnits = 0;
        for (var item : cart) {
            totalUnits += item.qty;
        }

        System.out.println("Checkout lines: " + cart.size());
        System.out.println("Units in cart: " + totalUnits);
        System.out.println("SKU-100 qty: " + qtyBySku.get("SKU-100"));
    }
}
