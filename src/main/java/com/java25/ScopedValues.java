package com.java25;

public class ScopedValues {

    static final ScopedValue<String> TENANT = ScopedValue.newInstance();
    static final ScopedValue<String> USER = ScopedValue.newInstance();

    static String priceFor(String sku) {
        return TENANT.get() + " / " + USER.get() + " → " + sku + " = ₹1999";
    }

    public static void main(String[] args) {
        ScopedValue.where(TENANT, "retail-in")
                .where(USER, "asha")
                .run(() -> System.out.println(priceFor("SKU-100")));

        String audit = ScopedValue.where(TENANT, "retail-eu")
                .where(USER, "ops-bot")
                .call(() -> priceFor("SKU-200"));
        System.out.println(audit);
    }
}
