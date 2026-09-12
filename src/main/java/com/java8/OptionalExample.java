package com.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalExample {

    static final class Customer {
        final String name;
        final String email;

        Customer(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    private static final Map<String, Customer> CRM = new HashMap<String, Customer>();

    static {
        CRM.put("C-100", new Customer("Asha", "asha@retail.com"));
        CRM.put("C-200", new Customer("Ravi", null));
    }

    static Optional<Customer> findCustomer(String id) {
        return Optional.ofNullable(CRM.get(id));
    }

    public static void main(String[] args) {
        String greeting = findCustomer("C-100")
                .map(c -> "Hello, " + c.name)
                .orElse("Hello, guest");

        String email = findCustomer("C-200")
                .map(c -> c.email)
                .filter(e -> e != null && e.contains("@"))
                .orElse("no-reply@retail.com");

        Customer missing = findCustomer("C-999")
                .orElseGet(() -> new Customer("Guest", "guest@retail.com"));

        System.out.println(greeting);
        System.out.println("Invoice email: " + email);
        System.out.println("Fallback customer: " + missing.name);
    }
}
