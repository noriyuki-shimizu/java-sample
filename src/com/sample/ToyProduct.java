package com.sample;

public class ToyProduct {
    private String name;

    private int price;

    public ToyProduct(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "[商品名: " + this.name + " 価格: " + this.price + "円]";
    }
}
