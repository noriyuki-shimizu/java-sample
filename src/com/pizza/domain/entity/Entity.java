package com.pizza.domain.entity;

public abstract class Entity<ID> implements Cloneable {
    protected final ID id;
    protected final long order;

    protected Entity(final ID id, long order) {
        this.id = id;
        this.order = order;
    }

    public ID getId() {
        return id;
    }

    public long getOrder() {
        return order;
    }

    @Override
    public abstract String toString();

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
