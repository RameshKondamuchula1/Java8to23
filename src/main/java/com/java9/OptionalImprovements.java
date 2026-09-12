package com.java9;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalImprovements {

    static Optional<String> primaryEmail(String customerId) {
        return "C-1".equals(customerId) ? Optional.of("asha@retail.com") : Optional.empty();
    }

    static Optional<String> backupEmail(String customerId) {
        return Optional.of(customerId + "@backup.retail.com");
    }

    public static void main(String[] args) {
        primaryEmail("C-1").ifPresentOrElse(
                email -> System.out.println("Send invoice to " + email),
                () -> System.out.println("Ask customer to add an email")
        );

        String reachable = primaryEmail("C-99")
                .or(() -> backupEmail("C-99"))
                .orElse("support@retail.com");
        System.out.println("Reachable inbox: " + reachable);

        List<String> campaignList = List.of("C-1", "C-2", "C-99").stream()
                .map(OptionalImprovements::primaryEmail)
                .flatMap(Optional::stream)
                .collect(Collectors.toList());
        System.out.println("Customers with a primary email: " + campaignList);
    }
}
