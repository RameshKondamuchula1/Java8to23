package com.java21;

public class RecordPatterns {

    record Address(String city, String zip) {
    }

    record Customer(String name, Address address) {
    }

    static String warehouseHint(Object payload) {
        if (payload instanceof Customer(String name, Address(String city, String zip))) {
            return name + " ships to " + city + " (" + zip + ")";
        }
        return "Cannot route shipment";
    }

    public static void main(String[] args) {
        var asha = new Customer("Asha", new Address("Pune", "411001"));
        System.out.println(warehouseHint(asha));
        System.out.println(warehouseHint("not a customer"));
    }
}
