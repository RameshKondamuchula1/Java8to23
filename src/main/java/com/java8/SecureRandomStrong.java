package com.java8;

import java.security.SecureRandom;

public class SecureRandomStrong {

    public static void main(String[] args) throws Exception {
        SecureRandom rng = SecureRandom.getInstanceStrong();
        int otp = 100000 + rng.nextInt(900000);
        System.out.println("Login OTP (strong RNG): " + otp);
    }
}
