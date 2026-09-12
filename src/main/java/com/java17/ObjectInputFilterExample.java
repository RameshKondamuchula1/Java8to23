package com.java17;

import java.io.ObjectInputFilter;

public class ObjectInputFilterExample {

    public static void main(String[] args) {
        ObjectInputFilter allowRetail = ObjectInputFilter.Config.createFilter(
                "com.java17.**;java.base/*;!*"
        );
        ObjectInputFilter.FilterInfo info = new ObjectInputFilter.FilterInfo() {
            @Override
            public Class<?> serialClass() {
                return String.class;
            }

            @Override
            public long arrayLength() {
                return -1;
            }

            @Override
            public long depth() {
                return 1;
            }

            @Override
            public long references() {
                return 1;
            }

            @Override
            public long streamBytes() {
                return 8;
            }
        };
        System.out.println("Deserialize String? " + allowRetail.checkInput(info));
        System.out.println("Use ObjectInputFilter on ObjectInputStream to block gadget attacks.");
    }
}
