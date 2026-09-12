package com.java19;

import java.util.Objects;

public class ObjectsIdentity {

    public static void main(String[] args) {
        Object cart = new Object();
        System.out.println("Debug identity (ignores toString override): " + Objects.toIdentityString(cart));
    }
}
