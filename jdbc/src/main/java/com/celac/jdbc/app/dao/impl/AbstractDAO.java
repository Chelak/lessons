package com.celac.jdbc.app.dao.impl;

import com.celac.jdbc.app.dao.Operations;

import java.io.Serializable;
import java.sql.Connection;

public abstract class AbstractDAO<T extends Serializable> implements Operations<T> {
  private final Connection dataSourcesConnection;

  public AbstractDAO(Connection dataSourcesConnection) {
    this.dataSourcesConnection = dataSourcesConnection;
  }

  protected Connection getDataSourcesConnection() {
    return dataSourcesConnection;
  }
}
