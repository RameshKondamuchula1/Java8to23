package com.java23;

import module java.base;

public class ModuleImport {

    public static void main(String[] args) {
        List<String> hubs = List.of("Pune", "Mumbai", "Delhi");
        Map<String, Integer> slaHours = Map.of("Pune", 24, "Mumbai", 24, "Delhi", 36);

        Optional<String> nearest = hubs.stream().findFirst();
        System.out.println("Dispatch hub: " + nearest.orElse("HQ"));
        System.out.println("Delhi SLA: " + slaHours.get("Delhi") + "h");
    }
}
