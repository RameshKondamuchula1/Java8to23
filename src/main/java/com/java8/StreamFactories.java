package com.java8;

import java.util.stream.Stream;

public class StreamFactories {

    public static void main(String[] args) {
        Stream<String> emptyReturns = Stream.empty();
        Stream<String> one = Stream.of("O-1");
        Stream<String> many = Stream.of("O-1", "O-2", "O-3");

        Stream<Integer> invoiceSeq = Stream.iterate(1001, n -> n + 1).limit(3);
        Stream<String> otpStream = Stream.generate(() -> "OTP-" + (100000 + (int) (Math.random() * 900000))).limit(2);
        Stream<String> merged = Stream.concat(one, Stream.of("O-99"));

        Stream<String> built = Stream.<String>builder().add("WH-PUNE").add("WH-DEL").build();

        System.out.println("Empty return queue: " + emptyReturns.count());
        System.out.println("Single / many: " + many.count());
        invoiceSeq.forEach(id -> System.out.println("Next invoice: INV-" + id));
        otpStream.forEach(otp -> System.out.println("Login " + otp));
        System.out.println("Concat size: " + merged.count());
        built.forEach(wh -> System.out.println("Warehouse: " + wh));
    }
}
