package com.java13;

public class TextBlocks {

    public static void main(String[] args) {
        String createOrderJson = """
                {
                  "customerId": "C-100",
                  "sku": "SKU-8891",
                  "qty": 2,
                  "city": "Pune"
                }
                """;

        String refundEmail = """
                Hi Asha,
                
                We refunded ₹1,299 for order O-441.
                It will reach your account in 3–5 business days.
                """;

        System.out.println("Checkout payload:\n" + createOrderJson);
        System.out.println(refundEmail);
    }
}
