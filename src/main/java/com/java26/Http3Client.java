package com.java26;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Http3Client {

    public static void main(String[] args) {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_3)
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
            System.out.println("Catalog API negotiated: " + response.version());
            System.out.println("Status: " + response.statusCode());
        } catch (Exception ex) {
            System.out.println("Catalog API unreachable — use last snapshot. (" + ex.getClass().getSimpleName() + ")");
        }
    }
}
