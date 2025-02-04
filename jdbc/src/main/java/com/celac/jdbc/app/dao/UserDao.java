package com.celac.jdbc.app.dao;

import com.celac.jdbc.app.entities.User;

import java.util.List;

public interface UserDao extends Operations<User> {

  List<User> selectAllPageable(int fromRow, int rows);

  int[] batchInsert(List<User> userList);

  int[] batchUpdate(List<User> userList);
}
