package com.java25;

import javax.crypto.KDF;
import javax.crypto.SecretKey;
import javax.crypto.spec.HKDFParameterSpec;
import java.nio.charset.StandardCharsets;
import java.util.HexFormat;

public class KdfApi {

    public static void main(String[] args) throws Exception {
        byte[] master = "store-root-secret".getBytes(StandardCharsets.UTF_8);
        byte[] salt = "orders-service".getBytes(StandardCharsets.UTF_8);
        byte[] info = "tenant-in:card-token".getBytes(StandardCharsets.UTF_8);

        var spec = HKDFParameterSpec.ofExtract()
                .addIKM(master)
                .addSalt(salt)
                .thenExpand(info, 32);

        KDF hkdf = KDF.getInstance("HKDF-SHA256");
        SecretKey cardTokenKey = hkdf.deriveKey("AES", spec);
        byte[] raw = hkdf.deriveData(spec);

        System.out.println("Derived AES key for card tokens: " + cardTokenKey.getAlgorithm());
        System.out.println("Fingerprint: " + HexFormat.of().formatHex(raw).substring(0, 16) + "…");
    }
}
