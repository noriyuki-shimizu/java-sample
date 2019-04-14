package com.sample3;

import java.text.NumberFormat;

public class Price {

    private long value;

    private static final double TAX = 1.08;

    private static final Integer MAX = 2147483647;

    private static final Integer MIN = -2147483647;

    public Price(long value) {
        if(value > this.MAX || value < this.MIN) {
            throw new IllegalArgumentException("引数情報が不正です。");
        }

        this.value = value;
    }

    public long get() {
        return this.value;
    }

    public Price getServicePrice() {
        double servicePrice = this.value - Math.floor(this.value % 100);
        return new Price((long) servicePrice);
    }

    public Price getPlusTax() {
        double plusTaxPrice = this.value * this.TAX;
        return new Price((long) plusTaxPrice);
    }

    public String priceFormat() {
        NumberFormat numberFormat = NumberFormat.getInstance();

        return numberFormat.format(this.value);
    }
}
