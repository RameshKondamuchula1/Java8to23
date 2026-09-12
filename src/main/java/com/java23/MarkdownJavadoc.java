package com.java23;

public class MarkdownJavadoc {

    /// Calculates payable amount after a **loyalty** discount.
    ///
    /// Rules:
    /// - 10 or more past orders → `10%` off
    /// - otherwise no discount
    ///
    /// @param mrp catalogue price
    /// @param pastOrders completed orders this year
    /// @return net payable in INR
    static double payable(double mrp, int pastOrders) {
        return pastOrders >= 10 ? Math.round(mrp * 0.90) : mrp;
    }

    public static void main(String[] args) {
        System.out.println("Loyal customer pays ₹" + payable(1999, 12));
        System.out.println("New customer pays ₹" + payable(1999, 1));
    }
}
