package com.celac.jdbc.app.config;

import com.celac.jdbc.app.util.LocalConfigurationPropertiesLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourcesConfiguration {

    private static final Properties environment = LocalConfigurationPropertiesLoader.getInstance();

    public Connection getConnection() {
        System.out.println("Init data base connection");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    prepareDataSourceURL(),
                    environment.getProperty("datasource.username"),
                    environment.getProperty("datasource.password")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private String prepareDataSourceURL() {
        String dataSourceURL = environment.getProperty("datasource.url.template")
                .replace("URL", environment.getProperty("datasource.url"))
                .replace("PORT", environment.getProperty("datasource.port"))
                .replace("DB_NAME", environment.getProperty("datasource.name"));
        return dataSourceURL;
    }


}
