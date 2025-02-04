package com.celac.jdbc.app.dao.impl;

import com.celac.jdbc.app.dao.Operations;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

public abstract class AbstractDAO<T extends Serializable> implements Operations<T> {
  private final Connection dataSourcesConnection;

  public AbstractDAO(Connection dataSourcesConnection) {
    this.dataSourcesConnection = dataSourcesConnection;
  }

  protected Connection getDataSourcesConnection() {
    return dataSourcesConnection;
  }

  @Override
  public T findOne(Long id) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public List<T> findAll() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void create(final T entity) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public T update(final T entity) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void delete(final T entity) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void deleteById(final long entityId) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
