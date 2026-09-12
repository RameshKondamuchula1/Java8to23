package com.java15;

public class TextBlocksStandard {

    public static void main(String[] args) {
        String sql = """
                SELECT o.id, o.amount
                  FROM orders o
                 WHERE o.city = 'Pune'
                   AND o.status = 'PAID'
                """;

        String singleLineJson = """
                {"sku":"SKU-100","qty":2}\
                """;

        System.out.println("Reporting query:\n" + sql);
        System.out.println("Packed JSON: [" + singleLineJson + "]");
        System.out.println("JSON length: " + singleLineJson.length());
    }
}
