package com.celac.jdbc.app.dao;

import java.util.List;

public interface Operations<T> {
    T findOne(final Long id);

    List<T> findAll();

    void create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);
}
