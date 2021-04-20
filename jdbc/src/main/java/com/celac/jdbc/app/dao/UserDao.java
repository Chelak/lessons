package com.celac.jdbc.app.dao;

import com.celac.jdbc.app.entities.User;

import java.util.List;

public interface UserDao extends Operations<User> {
  List<User> selectAllPageable(int fromRow, int rows);

  User findByUsername(String userName);

  void deleteByUserName(String username);
}
