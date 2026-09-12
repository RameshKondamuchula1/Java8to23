package com.java25;

import module java.base;
import module java.sql;
import java.util.Date;

public class ModuleImport {

    public static void main(String[] args) {
        Date placedOn = new Date();
        List<String> openTickets = List.of("T-441", "T-442");
        Map<String, Integer> slaHours = Map.of("Pune", 24, "Delhi", 36);

        System.out.println("OMS clock: " + placedOn);
        System.out.println("Open tickets: " + openTickets);
        System.out.println("Delhi SLA: " + slaHours.get("Delhi") + "h");
    }
}
