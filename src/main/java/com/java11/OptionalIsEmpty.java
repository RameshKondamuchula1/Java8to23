package com.java11;

import java.util.Optional;

public class OptionalIsEmpty {

    static Optional<String> giftWrapSku(boolean optedIn) {
        return optedIn ? Optional.of("WRAP-GOLD") : Optional.empty();
    }

    public static void main(String[] args) {
        Optional<String> wrap = giftWrapSku(false);
        if (wrap.isEmpty()) {
            System.out.println("Skip gift-wrap line item at checkout.");
        }
    }
}
