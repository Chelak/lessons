package org.lessons.scelac.dao.impl;

import org.lessons.scelac.dao.AbstractDao;
import org.lessons.scelac.dao.UserDao;
import org.lessons.scelac.model.User;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author scelac
 */
@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

  public UserDaoImpl(DataSource dataSource) {
    super(dataSource);
  }

  @Override
  public User getById(Long userId) {
      String sql =
              "SELECT  u.id AS u_id, u.first_name, u.last_name, u.user_name, "
                      + " u.enabled, u.created_date, u.last_login_date, r.id as r_id,r.role_name "
                      + " FROM users AS u INNER JOIN user_role AS r ON u.role = r.id WHERE u.id  = ?";

      return getJdbcTemplate().queryForObject(sql, new Object[] {userId}, new UserMapper());
  }

  @Override
  public User findByUserName(String userName) {
    String sql =
        "SELECT  u.id AS u_id, u.first_name, u.last_name, u.user_name, "
            + " u.enabled, u.created_date, u.last_login_date, u.password, r.id as r_id,r.role_name "
            + " FROM users AS u INNER JOIN user_role AS r ON u.role = r.id WHERE u.user_name  = ?";

    return getJdbcTemplate().queryForObject(sql, new Object[] {userName}, new UserMapper());
  }

  @Override
  public boolean existsByEmail(String email) {
    String sql = "SELECT u.id FROM users u WHERE u.user_name = " + email;
    Long id = getJdbcTemplate().queryForObject(sql, Long.class);
    return id != null;
  }

  @Override
  public User save(User user) {
    Map<String, Object> params = new HashMap<>();
    params.put("first_name", user.getFirstName());
    params.put("last_name", user.getLastName());
    params.put("user_name", user.getUserName());
    // todo: :))))
    params.put("role", user.getRoles().get(0).getId());

    params.put("enabled", true);
    params.put("password", user.getPassword());
    params.put("created_date", new Date());

    SimpleJdbcInsert simpleJdbcInsert =
        new SimpleJdbcInsert(getJdbcTemplate().getDataSource()).withTableName("users");
    Number newId = simpleJdbcInsert.executeAndReturnKey(params);
    return getById((long) newId);
  }
}
