package com.pizza.domain.entity.store;

import com.pizza.domain.entity.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class DataStore<T extends Entity<ID>, ID> {
    private final List<T> box;

    private DataStore() {
        box = new ArrayList<>();
    }

    public static <T extends Entity<ID>, ID> DataStore<T, ID> of() {
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
        box.sort(Comparator.comparing(Entity::getOrder));
    }

    public void addAll(List<T> entities) {
        box.addAll(entities);
        box.sort(Comparator.comparing(Entity::getOrder));
    }

    public boolean remove(T entity) {
        return box.remove(entity);
    }

    public boolean removeAll(Collection<T> entities) {
        return box.removeAll(entities);
    }
}
