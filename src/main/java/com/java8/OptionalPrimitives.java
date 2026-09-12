package com.java8;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class OptionalPrimitives {

    public static void main(String[] args) {
        OptionalInt qty = OptionalInt.of(2);
        OptionalLong orderNo = OptionalLong.empty();
        OptionalDouble gmv = OptionalDouble.of(2499.0);

        System.out.println("Cart qty: " + qty.orElse(0));
        System.out.println("Order no present: " + orderNo.isPresent());
        System.out.println("GMV: ₹" + gmv.orElse(0));
    }
}
