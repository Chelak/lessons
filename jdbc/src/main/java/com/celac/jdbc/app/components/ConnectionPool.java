package com.celac.jdbc.app.components;

import java.sql.Connection;

public interface ConnectionPool {
  Connection getConnection();

  boolean releaseConnection(Connection connection);
}
