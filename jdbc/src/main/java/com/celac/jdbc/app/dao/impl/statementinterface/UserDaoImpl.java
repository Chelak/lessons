package com.celac.jdbc.app.dao.impl.statementinterface;

import com.celac.jdbc.app.dao.UserDao;
import com.celac.jdbc.app.dao.impl.AbstractDAO;
import com.celac.jdbc.app.entities.User;

import com.celac.jdbc.app.sql.PageRequest;
import com.celac.jdbc.app.sql.PageResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDaoImpl extends AbstractDAO<User> implements UserDao {
  private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);
  public UserDaoImpl(DataSource dataSource) {
    super(dataSource);
  }

  @Override
  public User findOne(Long id) {
    String sql = "select u.* from users u where u.id = " + id;
    User user = null;

    try (Statement statement = getConnection().createStatement();
         ResultSet result = statement.executeQuery(sql)) {
      while (result.next()) {
        user =
            new User(
                result.getLong("id"),
                result.getString("user_name"),
                result.getString("first_name"),
                result.getString("last_name"));
      }

    } catch (SQLException e) {
      logger.error(e);
    }

    return user;
  }

  @Override
  public User findByUsername(String userName) {
    return null;
  }

  @Override
  public List<User> selectAllPageable(int fromRow, int rows) {
    List<User> users = new ArrayList<>(rows);
    String sql = "SELECT * FROM users u  LIMIT" + fromRow + "," + rows;
    try (Statement statement = getConnection().createStatement();
         ResultSet result = statement.executeQuery(sql)) {
      while (result.next()) {
        users.add(
            new User(
                result.getLong("id"),
                result.getString("user_name"),
                result.getString("first_name"),
                result.getString("last_name")));
      }

    } catch (SQLException e) {
      logger.error(e);
    }
    return users;
  }

  @Override
  public void deleteByUserName(String username) {}

  @Override
  public PageResponse<User> selectAllPaginated(PageRequest pageRequest) {
    return null;
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
