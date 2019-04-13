package com.company;

public class Sample {
    public String name;

    Sample(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "名前: " + this.name;
    }
}
