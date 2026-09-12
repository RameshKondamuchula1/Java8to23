package com.java22;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

public class ForeignMemory {

    public static void main(String[] args) {
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment orderIds = arena.allocate(ValueLayout.JAVA_INT, 3);
            orderIds.setAtIndex(ValueLayout.JAVA_INT, 0, 441);
            orderIds.setAtIndex(ValueLayout.JAVA_INT, 1, 442);
            orderIds.setAtIndex(ValueLayout.JAVA_INT, 2, 443);

            MemorySegment note = arena.allocateFrom("priority-dispatch");

            System.out.println("Off-heap first order id: " + orderIds.getAtIndex(ValueLayout.JAVA_INT, 0));
            System.out.println("Off-heap note: " + note.getString(0));
        }
        System.out.println("Arena closed — off-heap checkout buffer released.");
    }
}
