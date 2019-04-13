package com.sample3.foods.serial;

public class Id {

    private long value;

    private static long count = 0;

    public Id() {
        count ++;
        this.value = count;
    }

    public long get() {
        return this.value;
    }
}
