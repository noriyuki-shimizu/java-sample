package com.sample;

public class ToyMaterial {
    private String name;

    private int cost;

    public ToyMaterial(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }
}

