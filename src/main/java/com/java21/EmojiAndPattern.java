package com.java21;

import java.util.regex.Pattern;

public class EmojiAndPattern {

    public static void main(String[] args) {
        int cart = "🛒".codePointAt(0);
        Pattern tracking = Pattern.compile(":+");
        String[] parts = tracking.splitWithDelimiters("O-441:::WH-PUNE", -1);

        System.out.println("Cart emoji? " + Character.isEmoji(cart));
        System.out.println("Presentation? " + Character.isEmojiPresentation(cart));
        System.out.println("Tracking split: " + String.join(" | ", parts));
    }
}
