package com.pizza.domain.entity;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class Topping extends Entity<String> {
    private static final AtomicLong ORDER_INDEX = new AtomicLong();

    private final String name;
    private final int money;

    private Topping(final String name, final int money) {
        super(UUID.randomUUID().toString(), ORDER_INDEX.incrementAndGet());
        this.name = name;
        this.money = money;
    }

    public static Topping of(final String name, final int money) {
        return new Topping(name, money);
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return String.format("topping: { id=%s, order=%2d, name=%s, money=%4d }", super.id, super.order, name, money);
    }
}
