package com.celac.jdbc.app.dao.impl;

import com.celac.jdbc.app.config.DataSourcesConfiguration;
import com.celac.jdbc.app.dao.impl.preparedstatementinterface.UserDaoImpl;
import com.celac.jdbc.app.entities.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoImplTest {
    private UserDaoImpl userDao;

    @Before
    public void setUp() throws Exception {
        DataSourcesConfiguration dataSourcesConfiguration = new DataSourcesConfiguration();
        userDao = new UserDaoImpl(dataSourcesConfiguration.getConnection());

    }

    @Test
    public void findOneTest() {
        User user = userDao.findOne(1l);
        assertNotNull(user);
        assert user.getId().equals(1l);
    }

    @Test
    public void selectAllPageableTest() {
        List<User> userList = userDao.selectAllPageable(0, 6);
        assert !userList.isEmpty();
        assert userList.size() == 6;

        List<User> userList2 = userDao.selectAllPageable(0, 8);
        assert !userList2.isEmpty();
        assert userList2.size() == 8;
    }

    @Test
    public void create() {
        User user = new User();
        user.setUserName("ion.cudoi@gmail.com");
        userDao.create(user);
        User userCreated = userDao.findByUsername("ion.cudoi@gmail.com");
        assertEquals(userCreated.getUserName(),"ion.cudoi@gmail.com" );

    }

    @Test
    public void update() {
        User user =  userDao.findByUsername("ion.cudoi@gmail.com");
        user.setUserName("ion.cutrei@gmail.com");
        User updated =  userDao.update(user);
        assertEquals(updated.getUserName(), "ion.cutrei@gmail.com");

    }

    @Test
    public void delete() {
        userDao.deleteByUserName("ion.cutrei@gmail.com");
        assertNull(userDao.findByUsername("ion.cutrei@gmail.com"));
    }

}