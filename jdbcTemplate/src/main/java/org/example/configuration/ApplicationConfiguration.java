package org.example.configuration;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@ComponentScan(value = "org.example")
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {

    @Bean
    public DataSource dataSource(Environment environment) {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(environment.getProperty("datasource.url"));
        driverManagerDataSource.setUsername(environment.getProperty("datasource.username"));
        driverManagerDataSource.setPassword(environment.getProperty("datasource.password"));
        driverManagerDataSource.setDriverClassName(environment.getProperty("datasource.driver-class-name"));
        return driverManagerDataSource;
    }
    @Bean
    public SpringLiquibase springLiquibase(DataSource dataSource, Environment environment) throws SQLException {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDropFirst(true);
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog(environment.getProperty("spring.liquibase.change-log"));
        return liquibase;
    }
}
