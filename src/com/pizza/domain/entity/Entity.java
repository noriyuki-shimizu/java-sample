package com.pizza.domain.entity;

import java.util.UUID;

public abstract class Entity {
    protected final String id;

    protected Entity() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    @Override
    public abstract String toString();
}
