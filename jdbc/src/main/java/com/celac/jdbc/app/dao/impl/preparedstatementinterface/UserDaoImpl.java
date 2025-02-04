package com.celac.jdbc.app.dao.impl.preparedstatementinterface;

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
  // JDBC Transaction Management Example
  @Override
  public void create(User entity) {
    String sql = "INSERT INTO users (user_name, first_name, last_name) VALUES (?,?,?)";
    Connection conn = getDataSourcesConnection();
    try {
      // STEP 1 - Disable auto commit mode
      conn.setAutoCommit(false);
      // Create insert statement
      try (PreparedStatement statement = conn.prepareStatement(sql)) {
        statement.setString(1, entity.getUserName());
        statement.setString(2, entity.getFirstName());
        statement.setString(3, entity.getLastName());
        statement.executeUpdate();
        // STEP 2 - Commit insert and update statement
        conn.commit();
      } catch (SQLException e) {
        if (conn != null) {
          try {
            // STEP 3 - Roll back transaction
            System.out.println("Transaction is being rolled back.");
            conn.rollback();
          } catch (Exception ex) {
            ex.printStackTrace();
          }
        }
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
  public int[] batchInsert(List<User> userList) {
    int[] updateCounts = null;
    String sql = "INSERT INTO users (user_name, first_name, last_name) VALUES (?,?,?)";
    try (
    Connection connection  = getDataSourcesConnection();
    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      connection.setAutoCommit(false);
      for (User u : userList){
        preparedStatement.setString(1, u.getUserName());
        preparedStatement.setString(2, u.getFirstName());
        preparedStatement.setString(3, u.getLastName());
        preparedStatement.addBatch();
      }
       updateCounts = preparedStatement.executeBatch();
      connection.commit();
      connection.setAutoCommit(true);
    } catch (BatchUpdateException batchUpdateException) {
      printBatchUpdateException(batchUpdateException);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return updateCounts;
  }

  @Override
  public int[] batchUpdate(List<User> userList) {
    int[] updateCounts = null;
    String sql = "UPDATE users SET user_name = ? where id = ?";
    try (
      Connection connection  = getDataSourcesConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      connection.setAutoCommit(false);
      for (User u : userList){
        preparedStatement.setString(1, u.getUserName());
        preparedStatement.setLong(2, u.getId());
        preparedStatement.addBatch();
      }
      updateCounts = preparedStatement.executeBatch();
      connection.commit();
      connection.setAutoCommit(true);
    } catch (BatchUpdateException batchUpdateException) {
      printBatchUpdateException(batchUpdateException);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return updateCounts;
  }
  private void printBatchUpdateException(BatchUpdateException b) {
    System.err.println("----BatchUpdateException----");
    System.err.println("SQLState:  " + b.getSQLState());
    System.err.println("Message:  " + b.getMessage());
    System.err.println("Vendor:  " + b.getErrorCode());
    System.err.print("Update counts:  ");
    int[] updateCounts = b.getUpdateCounts();
    for (int i = 0; i < updateCounts.length; i++) {
      System.err.print(updateCounts[i] + "   ");
    }
  }

}
