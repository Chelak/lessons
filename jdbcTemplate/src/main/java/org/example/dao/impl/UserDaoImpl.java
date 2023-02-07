package org.example.dao.impl;

import org.example.dao.AbstractDao;
import org.example.dao.UserDao;
import org.example.domain.User;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

  public UserDaoImpl(DataSource dataSource) {
    super(dataSource);
  }

  @Override
  public User findOne(Long id) {
    String sql =
        "SELECT  u.id AS u_id, u.first_name, u.last_name, u.user_name, "
            + " u.enabled, u.created_date, u.last_login_date, r.id as r_id,r.role_name "
            + " FROM users AS u INNER JOIN user_role AS r ON u.role = r.id WHERE u.id  = ?";
    return getJdbcTemplate().queryForObject(sql, new Object[] {id}, new UserMapper());
  }

  @Override
  public void deleteById(long entityId) {}

  @Override
  public void create(User entity) {}

  @Override
  public User update(User entity) {
    return null;
  }

  @Override
  public void delete(User entity) {}
}
