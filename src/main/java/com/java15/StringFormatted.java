package com.java15;

public class StringFormatted {

    public static void main(String[] args) {
        String sms = "Refund of ₹%d for order %s is posted.".formatted(1299, "O-441");

        String emailTemplate = """
                    Dear Asha,
                        Your return was approved.
                """;
        String email = emailTemplate.stripIndent();

        String rawSku = "SKU\\t100\\n";
        String readable = rawSku.translateEscapes();

        System.out.println(sms);
        System.out.println("Help-center mail:\n" + email);
        System.out.println("Decoded SKU line: [" + readable + "]");
    }
}
