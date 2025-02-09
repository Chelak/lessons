package com.celac.jdbc.app.dao.impl;

import com.celac.jdbc.app.dao.Operations;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

public abstract class AbstractDAO<T extends Serializable> implements Operations<T> {
  private final DataSource dataSource;

  public AbstractDAO(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  protected Connection getConnection() throws SQLException {
    return dataSource.getConnection();
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
