package com.pizza.domain;

import java.util.List;
import java.util.function.IntUnaryOperator;

public enum  ProductSize {
    SMALL("S", 0.8, price -> (int) (price * 0.8)),
    MEDIUM("M", 1.0, price -> (int) (price * 1.0)),
    LARGE("L", 1.2, price -> (int) (price * 1.2))
    ;
    
    private final String label;
    private final double ratio;
    private final IntUnaryOperator intUnaryOperator;
    
    ProductSize(final String label, final double ratio, final IntUnaryOperator intUnaryOperator) {
        this.label = label;
        this.ratio = ratio;
        this.intUnaryOperator = intUnaryOperator;
    }

    public int calc(int price) {
        return this.intUnaryOperator.applyAsInt(price);
    }

    public String getLabel() {
        return label;
    }

    public double getRatio() {
        return ratio;
    }
}
