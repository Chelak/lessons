package com.celac.jdbc.app.dao;

import com.celac.jdbc.app.entities.User;

import com.celac.jdbc.app.sql.PageRequest;
import com.celac.jdbc.app.sql.PageResponse;
import java.util.List;

public interface UserDao extends Operations<User> {
  User findByUsername(String userName);

  List<User> selectAllPageable( int fromRow, int rows);

  PageResponse<User> selectAllPaginated(PageRequest pageRequest );

  int[] batchInsert(List<User> userList);

  int[] batchUpdate(List<User> userList);
}
