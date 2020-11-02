package com.pizza.domain.entity.store;

import com.pizza.domain.entity.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class DataStore<T extends Entity> {
    private final List<T> box;

    private DataStore() {
        box = new ArrayList<>();
    }

    public static <T extends Entity> DataStore<T> of() {
        return new DataStore<>();
    }

    public T get(int i) {
        return box.get(i);
    }

    public List<T> get() {
        return box;
    }

    public void add(T entity) {
        box.add(entity);
        box.sort(Comparator.comparing(Entity::getAddedAt));
    }

    public void addAll(List<T> entities) {
        box.addAll(entities);
        box.sort(Comparator.comparing(Entity::getAddedAt));
    }

    public boolean remove(T entity) {
        return box.remove(entity);
    }

    public boolean removeAll(Collection<T> entities) {
        return box.removeAll(entities);
    }
}
