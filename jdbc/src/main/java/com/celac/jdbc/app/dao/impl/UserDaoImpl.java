package com.celac.jdbc.app.dao.impl;

import com.celac.jdbc.app.dao.UserDao;
import com.celac.jdbc.app.entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDAO<User> implements UserDao {

  public UserDaoImpl(Connection dataSourcesConnection) {
    super(dataSourcesConnection);
  }

  @Override
  public User findOne(Long id) {
    String sql = "select u.* from users u where u.id = ?";
    User user = null;

    try {
      PreparedStatement statement = getDataSourcesConnection().prepareStatement(sql);
      statement.setLong(1, id);

      ResultSet result = statement.executeQuery();
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
    String sql = "SELECT * FROM users u  LIMIT ?, ?";
    try {
      PreparedStatement statement = getDataSourcesConnection().prepareStatement(sql);
      statement.setInt(1, fromRow);
      statement.setInt(2, rows);

      ResultSet result = statement.executeQuery();
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
  public User findByUsername(String userName) {
    String sql = "select u.* from users u where u.user_name = ?";
    User user = null;
    try {
      PreparedStatement statement = getDataSourcesConnection().prepareStatement(sql);
      statement.setString(1, userName);
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        user =
            new User(
                result.getLong("id"),
                result.getString("user_name"),
                result.getString("first_name"),
                result.getString("last_name"));
        ;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return user;
  }

  @Override
  public void deleteByUserName(String username) {
    String sql = "DELETE FROM users WHERE user_name= ?";
    try {
      PreparedStatement statement = getDataSourcesConnection().prepareStatement(sql);
      statement.setString(1, username);
      int rowsDeleted = statement.executeUpdate();
      if (rowsDeleted > 0) {
        System.out.println("A user was deleted successfully!");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void create(User entity) {
    String sql = "INSERT INTO users (user_name, first_name, last_name) VALUES (?,?,?)";
    try {
      PreparedStatement statement = getDataSourcesConnection().prepareStatement(sql);
      statement.setString(1, entity.getUserName());
      statement.setString(2, entity.getFirstName());
      statement.setString(3, entity.getLastName());

      int rowsInserted = statement.executeUpdate();
      if (rowsInserted > 0) {
        System.out.println("A new user was inserted successfully!");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public User update(User user) {
    User updatedUser = null;
    String sql = "UPDATE users SET user_name = ? where id = ?";
    try {
      PreparedStatement statement = getDataSourcesConnection().prepareStatement(sql);
      statement.setString(1, user.getUserName());
      statement.setLong(2, user.getId());
      int rowsInserted = statement.executeUpdate();
      if (rowsInserted > 0) {
        System.out.println("An existing user was updated successfully!");
        updatedUser = findOne(user.getId());
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return updatedUser;
  }

  @Override
  public List<User> findAll() {
    return null;
  }

  @Override
  public void delete(User entity) {}

  @Override
  public void deleteById(long entityId) {}
}
