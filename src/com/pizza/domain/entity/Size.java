package com.pizza.domain.entity;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class Size extends Entity<String> {
    private static final AtomicLong ORDER_INDEX = new AtomicLong();

    private final String name;
    private final double ratio;

    private Size(final String name, final double ratio) {
        super(UUID.randomUUID().toString(), ORDER_INDEX.incrementAndGet());
        this.name = name;
        this.ratio = ratio;
    }

    public static Size of(final String name, final double ratio) {
        return new Size(name, ratio);
    }

    public String getName() {
        return name;
    }

    public double getRatio() {
        return ratio;
    }

    @Override
    public String toString() {
        return String.format("topping: { id=%s, order=%2d, name=%s, ratio=%4f }", super.id, super.order, name, ratio);
    }
}
