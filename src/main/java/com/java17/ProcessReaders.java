package com.java17;

public class ProcessReaders {

    public static void main(String[] args) throws Exception {
        Process child = new ProcessBuilder("echo", "SETTLED").start();
        try (var stdout = child.inputReader()) {
            System.out.println("Payment CLI said: " + stdout.readLine());
        }
        child.waitFor();
        System.out.println("Prefer Process.inputReader()/errorReader()/outputWriter() over raw getInputStream().");
    }
}
