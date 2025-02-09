package com.celac.jdbc.app;

import com.celac.jdbc.app.config.DataSourcesConfiguration;
import com.celac.jdbc.app.config.DatabaseHikariConnectionPool;
import com.celac.jdbc.app.dao.UserDao;
import com.celac.jdbc.app.dao.impl.preparedstatementinterface.UserDaoImpl;
import com.celac.jdbc.app.entities.User;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MainJDBCApp {
    private final static Logger logger = LogManager.getLogger(MainJDBCApp.class);
    public static void main(String[] args) throws IOException {

    UserDao userDao = new UserDaoImpl(DatabaseHikariConnectionPool.getDataSource());
    User user = userDao.findOne(1l);
    logger.info(user.toString());

  }
}
