package com.java11;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateNot {

    public static void main(String[] args) {
        List<String> searchTerms = List.of("laptop", " ", "phone", "", "  tablet");

        List<String> usable = searchTerms.stream()
                .map(String::strip)
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());

        System.out.println("Search keywords sent to catalog: " + usable);
    }
}
