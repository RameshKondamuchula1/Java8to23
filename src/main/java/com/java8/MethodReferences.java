package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferences {

    static final class Employee {
        final String name;
        final String department;

        Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        String getName() {
            return name;
        }

        static boolean isEngineering(Employee e) {
            return "Engineering".equals(e.department);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        List<String> rawNames = Arrays.asList("Asha,Engineering", "Ravi,Sales", "Neha,Engineering");

        List<Employee> engineers = rawNames.stream()
                .map(MethodReferences::toEmployee)
                .filter(Employee::isEngineering)
                .collect(Collectors.toList());

        List<String> names = engineers.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        names.forEach(System.out::println);
    }

    static Employee toEmployee(String row) {
        String[] parts = row.split(",");
        return new Employee(parts[0], parts[1]);
    }
}
