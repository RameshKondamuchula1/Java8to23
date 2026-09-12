package com.java18;

import com.sun.net.httpserver.SimpleFileServer;

import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;

public class SimpleWebServer {

    public static void main(String[] args) throws Exception {
        Path catalogDir = Files.createTempDirectory("catalog");
        Files.writeString(catalogDir.resolve("index.html"), "<h1>Today's deals</h1>");

        var server = SimpleFileServer.createFileServer(
                new InetSocketAddress(0),
                catalogDir,
                SimpleFileServer.OutputLevel.INFO
        );
        server.start();
        int port = server.getAddress().getPort();
        System.out.println("Static deal page at http://localhost:" + port + "/");
        server.stop(0);
        System.out.println("Server stopped — used only to host a folder of HTML/assets.");
    }
}
