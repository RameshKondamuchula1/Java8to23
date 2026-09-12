package com.java17;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class RandomGeneratorExample {

    public static void main(String[] args) {
        RandomGenerator otp = RandomGeneratorFactory.of("L64X128MixRandom").create();
        RandomGenerator promo = RandomGenerator.getDefault();

        int sixDigitOtp = 100000 + otp.nextInt(900000);
        int flashDiscount = 5 + promo.nextInt(16);

        System.out.println("Login OTP: " + sixDigitOtp);
        System.out.println("Flash sale extra off: " + flashDiscount + "%");
    }
}
