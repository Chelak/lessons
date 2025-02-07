package com.celac.jdbc.app.dao.impl.preparedstatementinterface;

import com.celac.jdbc.app.dao.UserDao;
import com.celac.jdbc.app.dao.impl.AbstractDAO;
import com.celac.jdbc.app.dao.mappers.UserListRowMapper;
import com.celac.jdbc.app.entities.User;

import com.celac.jdbc.app.sql.PageRequest;
import com.celac.jdbc.app.sql.PageResponse;
import com.celac.jdbc.app.sql.impl.PageResponseImpl;
import com.celac.jdbc.app.sql.impl.ResultSetProcessorImpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDaoImpl extends AbstractDAO<User> implements UserDao {
  private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);

  public UserDaoImpl(Connection dataSourcesConnection) {
    super(dataSourcesConnection);
  }

  @Override
  public User findOne(Long id) {
    String sql = "select u.* from users u where u.id = ?";
    User user = null;

    try (PreparedStatement statement = getDataSourcesConnection().prepareStatement(sql)) {
      statement.setLong(1, id);
      try (ResultSet result = statement.executeQuery()) {
        while (result.next()) {
          user =
              new User(
                  result.getLong("id"),
                  result.getString("user_name"),
                  result.getString("first_name"),
                  result.getString("last_name"));
        }
      }
    } catch (SQLException e) {
      logger.error(e);
    }

    return user;
  }

  @Override
  public List<User> selectAllPageable(int pageNumber, int pageSize) {
    List<User> users = new ArrayList<>();
    String sql = "SELECT u.id, u.user_name, u.first_name, u.last_name FROM users u  LIMIT ?, ?";
    try (PreparedStatement statement = getDataSourcesConnection().prepareStatement(sql)) {
      int offset = (pageNumber - 1) * pageSize;
      statement.setInt(1, pageSize);
      statement.setInt(2, offset);
      try (ResultSet result = statement.executeQuery()) {
        while (result.next()) {
          users.add(
              new User(
                  result.getLong("id"),
                  result.getString("user_name"),
                  result.getString("first_name"),
                  result.getString("last_name")));
        }
      }

    } catch (SQLException e) {
      logger.error(e);
    }
    return users;
  }

  @Override
  public PageResponse<User> selectAllPaginated(PageRequest pageRequest) {
    PageResponse pageResponse = null;
    long totalElements = 0 ;
    String sql = "SELECT u.id, u.user_name, u.first_name, u.last_name FROM users u  LIMIT ?, ?";
    try (PreparedStatement statement = getDataSourcesConnection().prepareStatement(sql)) {
      statement.setInt(1, pageRequest.getOffset());
      statement.setInt(2, pageRequest.getPageSize());
      try (ResultSet result = statement.executeQuery()) {
        List<User> users  = new ResultSetProcessorImpl<>(result, new UserListRowMapper()).process();
        totalElements =  getTotalElementsFromTableUsers();
        pageResponse = new PageResponseImpl(users,totalElements);
      }

    } catch (SQLException e) {
      logger.error(e);
      pageResponse = new PageResponseImpl(Collections.emptyList(),totalElements);
    }
    return pageResponse;
  }

  private long getTotalElementsFromTableUsers() {
    long totalElements = 0;
    String sql = "SELECT count(u.id)  FROM users as U";
    try (PreparedStatement statement = getDataSourcesConnection().prepareStatement(sql) ;
        ResultSet result = statement.executeQuery()) {
        totalElements = result.getLong(1);
    } catch (SQLException e) {
      logger.error(e);
       return totalElements;
    }
    return totalElements;
  }

  @Override
  public User findByUsername(String userName) {
    String sql = "select u.* from users u where u.user_name = ?";
    User user = null;
    try (PreparedStatement statement = getDataSourcesConnection().prepareStatement(sql)) {

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
      logger.error(e);
    }
    return user;
  }

  @Override
  public void deleteByUserName(String username) {
    String sql = "DELETE FROM users WHERE user_name= ?";
    try (PreparedStatement statement = getDataSourcesConnection().prepareStatement(sql)) {
      statement.setString(1, username);
      int rowsDeleted = statement.executeUpdate();
      if (rowsDeleted > 0) {
        logger.info("A user was deleted successfully!");
      }
    } catch (SQLException e) {
      logger.error(e);
    }
  }

  // JDBC Transaction Management Example
  @Override
  public void create(User entity) {
    String sql = "INSERT INTO users (user_name, first_name, last_name) VALUES (?,?,?)";
    try (Connection conn = getDataSourcesConnection(); ) {
      // STEP 1 - Disable auto commit mode
      conn.setAutoCommit(false);
      // Create insert statement
      try (PreparedStatement statement = conn.prepareStatement(sql)) {
        statement.setString(1, entity.getUserName());
        statement.setString(2, entity.getFirstName());
        statement.setString(3, entity.getLastName());
        // STEP 2 - Execute SQL statements within a transaction block.
        statement.executeUpdate();
        // STEP 3 - Commit insert and update statement
        conn.commit();
      } catch (SQLException e) {
        if (conn != null) {
          try {
            // STEP 4 - Roll back transaction
            logger.error("Transaction is being rolled back.");
            conn.rollback();
          } catch (Exception ex) {
            logger.error(ex);
          }
        }
      }
    } catch (SQLException e) {
      logger.error(e);
    }
  }

  @Override
  public User update(User user) {
    User updatedUser = null;
    String sql = "UPDATE users SET user_name = ? where id = ?";
    try (PreparedStatement statement = getDataSourcesConnection().prepareStatement(sql)) {
      statement.setString(1, user.getUserName());
      statement.setLong(2, user.getId());
      int rowsInserted = statement.executeUpdate();
      if (rowsInserted > 0) {
        logger.info("An existing user was updated successfully!");
        updatedUser = findOne(user.getId());
      }
    } catch (SQLException e) {
      logger.error(e);
    }

    return updatedUser;
  }

  @Override
  public int[] batchInsert(List<User> userList) {
    int[] updateCounts = null;
    String sql = "INSERT INTO users (user_name, first_name, last_name) VALUES (?,?,?)";
    try (Connection connection = getDataSourcesConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      connection.setAutoCommit(false);

      for (User u : userList) {
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
    try (Connection connection = getDataSourcesConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      connection.setAutoCommit(false);
      for (User u : userList) {
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
      logger.error(e);
    }
    return updateCounts;
  }

  private void printBatchUpdateException(BatchUpdateException b) {
    logger.error("----BatchUpdateException----");
    logger.error("SQLState:  " + b.getSQLState());
    logger.error("Message:  " + b.getMessage());
    logger.error("Vendor:  " + b.getErrorCode());
    logger.error("Update counts:  ");
    int[] updateCounts = b.getUpdateCounts();
    for (int i = 0; i < updateCounts.length; i++) {
      logger.error(updateCounts[i] + "   ");
    }
  }
}
