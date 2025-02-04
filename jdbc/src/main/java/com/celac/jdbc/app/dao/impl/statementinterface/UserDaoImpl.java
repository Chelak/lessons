package com.celac.jdbc.app.dao.impl.statementinterface;

import com.celac.jdbc.app.dao.UserDao;
import com.celac.jdbc.app.dao.impl.AbstractDAO;
import com.celac.jdbc.app.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDAO<User> implements UserDao {

  public UserDaoImpl(Connection dataSourcesConnection) {
    super(dataSourcesConnection);
  }

  @Override
  public User findOne(Long id) {
    String sql = "select u.* from users u where u.id = " + id;
    User user = null;

    try {
      Statement statement = getDataSourcesConnection().createStatement();
      ResultSet result = statement.executeQuery(sql);
      while (result.next()) {
        user =
            new User(
                result.getLong("id"),
                result.getString("user_name"),
                result.getString("first_name"),
                result.getString("last_name"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return user;
  }

  @Override
  public List<User> selectAllPageable(int fromRow, int rows) {
    List<User> users = new ArrayList<>(rows);
    String sql = "SELECT * FROM users u  LIMIT" + fromRow + "," + rows;
    try {
      Statement statement = getDataSourcesConnection().createStatement();
      ResultSet result = statement.executeQuery(sql);
      while (result.next()) {
        users.add(
            new User(
                result.getLong("id"),
                result.getString("user_name"),
                result.getString("first_name"),
                result.getString("last_name")));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return users;
  }

  @Override
  public int[] batchInsert(List<User> userList) {
    return new int[0];
  }

  @Override
  public int[] batchUpdate(List<User> userList) {
    return new int[0];
  }
}
