package com.celac.jdbc.app.components;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocalSimpleConnectionPool implements ConnectionPool {
  private List<Connection> connectionPool;
  private List<Connection> usedConnections = new ArrayList<>();

  private LocalSimpleConnectionPool(List<Connection> pool) {
    this.connectionPool = pool;
  }

  public static LocalSimpleConnectionPool create(
      String url, String user, String password, int poolSize) throws SQLException {
    List<Connection> pool = new ArrayList<>(poolSize);
    for (int i = 0; i < poolSize; i++) {
      pool.add(createConnection(url, user, password));
    }
    return new LocalSimpleConnectionPool(pool);
  }

  @Override
  public Connection getConnection() {
    Connection connection = connectionPool.remove(connectionPool.size() - 1);
    usedConnections.add(connection);
    return connection;
  }

  @Override
  public boolean releaseConnection(Connection connection) {
    connectionPool.add(connection);
    return usedConnections.remove(connection);
  }

  private static Connection createConnection(String url, String user, String password)
      throws SQLException {
    return DriverManager.getConnection(url, user, password);
  }
}
