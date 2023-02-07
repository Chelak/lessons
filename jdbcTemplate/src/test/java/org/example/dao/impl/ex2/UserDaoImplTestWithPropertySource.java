package org.example.dao.impl.ex2;

import org.example.dao.UserDao;
import org.example.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class UserDaoImplTestWithPropertySource extends AbstractDAOTestConfiguration {
  @Autowired private UserDao userDao;
  @Test
  public void findOne() {
    User user = userDao.findOne(1l);
    assertNotNull(user);
  }
}
