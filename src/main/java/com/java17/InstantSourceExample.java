package com.java17;

import java.time.Clock;
import java.time.Instant;
import java.time.InstantSource;

public class InstantSourceExample {

    static Instant invoiceTimestamp(InstantSource clock) {
        return clock.instant();
    }

    public static void main(String[] args) {
        InstantSource live = Clock.systemUTC();
        InstantSource frozen = InstantSource.fixed(Instant.parse("2026-09-12T06:00:00Z"));

        System.out.println("Live settlement clock: " + invoiceTimestamp(live));
        System.out.println("Replay test clock: " + invoiceTimestamp(frozen));
    }
}
