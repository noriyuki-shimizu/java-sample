package com.pizza.domain.entity;

public class Topping extends Entity {
    private final String name;
    private final int money;

    private Topping(final String name, final int money) {
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
        return String.format("topping: { id=%s, name=%s, money=%4d }", super.id, name, money);
    }
}
