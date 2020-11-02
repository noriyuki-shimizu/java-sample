package com.pizza.domain.repository;

import com.pizza.domain.entity.Entity;
import com.pizza.domain.entity.store.DataStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public abstract class AbstractRepository<E extends Entity, ID> implements Repository<E, ID> {
    protected final DataStore<E> STORE = DataStore.of();

    @Override
    public List<E> findAll() {
        final List<E> all = new ArrayList<>();
        for (E topping : STORE.get()) {
            try {
                @SuppressWarnings("unchecked") E clone = (E) topping.clone();
                all.add(clone);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return List.of();
            }
        }
        return all;
    }

    @Override
    public Optional<E> findById(ID id) {
        return STORE.get().stream()
                .filter(s -> s.getId().equals(id))
                .findAny();
    }

    @Override
    public List<E> findAllById(List<ID> ids) {
        if (ids.isEmpty()) {
            throw new IllegalArgumentException();
        }
        //noinspection SuspiciousMethodCalls
        return STORE.get().stream()
                .filter(S -> ids.contains(S.getId()))
                .collect(toList());
    }

    @Override
    public E save(E entity) {
        STORE.get().stream()
                .filter(s -> s.getId().equals(entity.getId()))
                .forEach(STORE::remove);

        STORE.add(entity);
        return entity;
    }

    @Override
    public List<E> saveAll(List<E> entities) {
        final List<String> ids = entities.stream().map(Entity::getId).collect(toList());
        STORE.get().stream()
                .filter(s -> ids.contains(s.getId()))
                .forEach(STORE::remove);

        STORE.addAll(entities);
        return entities;
    }

    @Override
    public void delete(E entity) {
        STORE.remove(entity);
    }

    @Override
    public void deleteAll(List<E> entities) {
        STORE.removeAll(entities);
    }
}