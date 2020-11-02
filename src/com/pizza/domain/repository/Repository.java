package com.pizza.domain.repository;

import com.pizza.domain.entity.Entity;

import java.util.List;
import java.util.Optional;

public interface Repository<E extends Entity, ID> {
    List<E> findAll();

    Optional<E> findById(ID id);

    List<E> findAllById(List<ID> ids);

    E save(E entity);

    List<E> saveAll(List<E> entities);

    void delete(E entity);

    void deleteAll(List<E> entities);
}
