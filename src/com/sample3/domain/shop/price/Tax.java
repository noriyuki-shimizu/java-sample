package com.sample3.domain.shop.price;

/**
 * 消費税.
 */
public class Tax {
    private static final double value = 1.08;

    public static double get() {
        return value;
    }
}
