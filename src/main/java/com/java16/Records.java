package com.java16;

import java.util.List;

public class Records {

    record OrderLine(String sku, int qty, double unitPrice) {
        OrderLine {
            if (qty <= 0) {
                throw new IllegalArgumentException("qty must be positive");
            }
        }

        double lineTotal() {
            return qty * unitPrice;
        }
    }

    record Invoice(String customer, List<OrderLine> lines) {
        double total() {
            return lines.stream().mapToDouble(OrderLine::lineTotal).sum();
        }
    }

    public static void main(String[] args) {
        var invoice = new Invoice("Asha", List.of(
                new OrderLine("SKU-100", 2, 799),
                new OrderLine("SKU-200", 1, 1499)
        ));

        System.out.println(invoice);
        System.out.println("Payable: ₹" + invoice.total());
        System.out.println("First SKU: " + invoice.lines().get(0).sku());
    }
}
