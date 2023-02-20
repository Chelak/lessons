package org.lessons.scelac.config.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author scelac
 */
@Configuration
public class DBConfiguration {
    @Bean
    public DataSource dataSource(Environment environment) {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(environment.getProperty("datasource.url"));
        driverManagerDataSource.setUsername(environment.getProperty("datasource.username"));
        driverManagerDataSource.setPassword(environment.getProperty("datasource.password"));
        driverManagerDataSource.setDriverClassName(environment.getProperty("datasource.driver-class-name"));
        return driverManagerDataSource;
    }
}
