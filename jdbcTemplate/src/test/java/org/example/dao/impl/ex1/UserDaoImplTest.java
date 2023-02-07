package org.example.dao.impl.ex1;

import org.example.dao.UserDao;
import org.example.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoLayerTestConfiguration.class)
public class UserDaoImplTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void findOne() {
        User user = userDao.findOne(1l);
        assertNotNull(user);
    }
}
