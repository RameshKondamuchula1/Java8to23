package com.java25;

public class InstanceMainMethods {

    void main() {
        IO.println("Nightly settlement started");
        IO.println(settle("O-441", 1299));
    }

    String settle(String orderId, int amount) {
        return "Posted ₹" + amount + " for " + orderId;
    }
}
