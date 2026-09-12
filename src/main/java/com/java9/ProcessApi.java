package com.java9;

public class ProcessApi {

    public static void main(String[] args) {
        ProcessHandle self = ProcessHandle.current();
        ProcessHandle.Info info = self.info();

        System.out.println("Order-service PID: " + self.pid());
        System.out.println("Command: " + info.command().orElse("unknown"));
        System.out.println("Started: " + info.startInstant().orElse(null));
        System.out.println("Alive: " + self.isAlive());
    }
}
