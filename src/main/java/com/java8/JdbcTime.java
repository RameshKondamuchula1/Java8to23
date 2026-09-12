package com.java8;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

public class JdbcTime {

    public static void main(String[] args) {
        LocalDate promised = LocalDate.of(2026, 9, 15);
        Date sqlDate = Date.valueOf(promised);
        LocalDate back = sqlDate.toLocalDate();

        Time slot = Time.valueOf(LocalTime.of(18, 30));
        Timestamp packed = Timestamp.from(Instant.parse("2026-09-12T13:00:00Z"));

        System.out.println("JDBC DATE → LocalDate: " + back);
        System.out.println("Slot TIME: " + slot.toLocalTime());
        System.out.println("Packed TIMESTAMP: " + packed.toInstant());
        System.out.println("JDBC 4.2: ps.setObject(1, promised) / rs.getObject(1, LocalDate.class)");
    }
}
