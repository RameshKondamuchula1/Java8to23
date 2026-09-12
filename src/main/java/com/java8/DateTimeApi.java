package com.java8;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeApi {

    public static void main(String[] args) {
        LocalDate orderDate = LocalDate.of(2026, 9, 10);
        LocalDate promisedDate = orderDate.plusDays(3);
        Period deliverySla = Period.between(orderDate, promisedDate);

        LocalDateTime packedAt = LocalDateTime.of(2026, 9, 11, 18, 30);
        Duration warehouseTime = Duration.between(orderDate.atStartOfDay(), packedAt);

        ZonedDateTime puneDispatch = ZonedDateTime.of(packedAt, ZoneId.of("Asia/Kolkata"));
        ZonedDateTime londonEta = puneDispatch.plusHours(11).withZoneSameInstant(ZoneId.of("Europe/London"));

        DateTimeFormatter uiFormat = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");

        System.out.println("SLA: " + deliverySla.getDays() + " days");
        System.out.println("Hours in warehouse: " + warehouseTime.toHours());
        System.out.println("London ETA: " + londonEta.format(uiFormat));
    }
}
