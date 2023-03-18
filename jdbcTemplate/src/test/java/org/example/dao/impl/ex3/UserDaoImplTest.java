package org.example.dao.impl.ex3;

import org.example.dao.UserDao;
import org.example.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest()
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserDaoImplTest {
  @Autowired private UserDao userDao;

  @Test
  public void findOne() {
    User user = userDao.findOne(1l);
    assertNotNull(user);
  }
}
