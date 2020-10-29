package com.pizza.domain.option;

public enum Size {
    SMALL("S", 0.8),
    MIDDLE("M", 1),
    LARGE("L", 1.2)
    ;

    private final String label;
    private final double ratio;

    Size(final String label, final double ratio) {
        this.label = label;
        this.ratio = ratio;
    }

    public String getLabel() {
        return label;
    }

    public double getRatio() {
        return ratio;
    }

    public int getAmountOfSize(int price) {
        return (int) (price * ratio);
    }
}
