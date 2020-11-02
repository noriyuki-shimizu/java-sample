package com.pizza.domain.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<E, ID> {
    List<E> findAll();

    Optional<E> findById(ID id);

    List<E> findAllById(List<ID> ids);

    E save(E entity);

    List<E> saveAll(List<E> entities);

    void delete(E entity);

    void deleteAll(List<E> entities);
}
