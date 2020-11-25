package com.pizza.domain;

public enum  ProductSize {
    SMALL("S", 0.8) {
        @Override
        public int calc(int price) {
            return (int) (price * SMALL.ratio);
        }
    },

    MEDIUM("M", 1.0){
        @Override
        public int calc(int price) {
            return (int) (price * MEDIUM.ratio);
        }
    },

    LARGE("L", 1.2){
        @Override
        public int calc(int price) {
            return (int) (price * LARGE.ratio);
        }
    }
    ;
    
    private final String label;
    private final Double ratio;
    
    ProductSize(final String label, final Double ratio) {
        this.label = label;
        this.ratio = ratio;
    }
    
    public abstract int calc(int price);

    public String getLabel() {
        return label;
    }

    public Double getRatio() {
        return ratio;
    }
}
