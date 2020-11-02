package com.pizza.domain.entity;

import java.util.UUID;

public abstract class Entity implements Cloneable {
    protected final String id;
    protected final long addedAt;

    protected Entity() {
        this.id = UUID.randomUUID().toString();
        addedAt = System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public long getAddedAt() {
        return addedAt;
    }

    @Override
    public abstract String toString();

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
