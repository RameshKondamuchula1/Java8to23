package com.java11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpClientExample {

    public static void main(String[] args) {
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(3))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/get"))
                .header("X-Tenant", "retail-in")
                .timeout(Duration.ofSeconds(5))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Pricing API status: " + response.statusCode());
            System.out.println("Body snippet: " + response.body().substring(0, Math.min(120, response.body().length())));
        } catch (Exception ex) {
            System.out.println("Pricing API unreachable — use cached catalog. (" + ex.getClass().getSimpleName() + ")");
        }
    }
}
