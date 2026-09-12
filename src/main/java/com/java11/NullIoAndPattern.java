package com.java11;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.regex.Pattern;

public class NullIoAndPattern {

    public static void main(String[] args) throws Exception {
        Pattern coupon = Pattern.compile("SAVE\\d+");
        boolean valid = coupon.asMatchPredicate().test("SAVE10");
        byte[] chunk = InputStream.nullInputStream().readNBytes(16);

        try (InputStream in = InputStream.nullInputStream();
             OutputStream out = OutputStream.nullOutputStream();
             Reader reader = Reader.nullReader();
             Writer writer = Writer.nullWriter()) {
            out.write(chunk);
            writer.write("ignored");
            System.out.println("Coupon SAVE10 valid: " + valid);
            System.out.println("Null I/O sinks ready (empty body=" + (in.read() == -1) + ", reader=" + (reader.read() == -1) + ")");
        }
    }
}
