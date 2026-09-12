package com.java23;

public class FlexibleConstructors {

    static class Person {
        final String name;

        Person(String name) {
            this.name = name;
        }
    }

    static class Employee extends Person {
        final int empId;

        Employee(String name, int empId) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("name required");
            }
            if (empId <= 0) {
                throw new IllegalArgumentException("empId must be positive");
            }
            super(name.strip());
            this.empId = empId;
        }
    }

    public static void main(String[] args) {
        var hire = new Employee("  Asha  ", 1042);
        System.out.println("Onboarded " + hire.name + " / EMP-" + hire.empId);

        try {
            new Employee("Ravi", -1);
        } catch (IllegalArgumentException ex) {
            System.out.println("Rejected hire: " + ex.getMessage());
        }
    }
}
