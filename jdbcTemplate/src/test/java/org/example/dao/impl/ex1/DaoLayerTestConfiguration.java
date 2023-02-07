package org.example.dao.impl.ex1;


import org.example.config.TestGlobalConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
//@Configuration
@Import(TestGlobalConfig.class)
public class DaoLayerTestConfiguration {

    @PostConstruct
    public void init(){
        System.out.println("---- invoked DaoLayerTestConfiguration ----");
    }
    @Bean
    public DataSource dataSource(Environment environment) {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl("jdbc:hsqldb:mem:testdb;DB_CLOSE_DELAY=-1");
        driverManagerDataSource.setUsername("sa");
        driverManagerDataSource.setPassword("");
        driverManagerDataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
        return driverManagerDataSource;
    }

}
