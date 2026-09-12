package com.java14;

public class HelpfulNpe {

    static final class Address {
        final String city;
        final String zip;

        Address(String city, String zip) {
            this.city = city;
            this.zip = zip;
        }
    }

    static final class Customer {
        final String name;
        final Address address;

        Customer(String name, Address address) {
            this.name = name;
            this.address = address;
        }
    }

    public static void main(String[] args) {
        Customer guest = new Customer("Guest", null);
        try {
            System.out.println(guest.address.zip);
        } catch (NullPointerException npe) {
            System.out.println(npe.getMessage());
        }
    }
}
