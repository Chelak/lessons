package com.celac.jdbc.app.config;

import com.celac.jdbc.app.util.LocalConfigurationPropertiesLoader;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This is utility class to configure the connection pool
 * @author scelac
 */
public class DatabaseHikariConnectionPool {
    private final static Logger logger = LogManager.getLogger(DatabaseHikariConnectionPool.class);
    private static final HikariDataSource dataSource;
    private static final Properties environment = LocalConfigurationPropertiesLoader.getInstance();

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(prepareDataSourceURL()); // In-memory DB
        config.setUsername(environment.getProperty("datasource.username"));
        config.setPassword(environment.getProperty("datasource.password"));
        config.setMaximumPoolSize(toInt(environment.getProperty("connection.pool.max.size")));
        config.setMinimumIdle(toInt(environment.getProperty("connection.pool.min.idle")));
        config.setIdleTimeout(toInt(environment.getProperty("connection.pool.idle.timeout")));
        config.setMaxLifetime(toInt(environment.getProperty("connection.pool.max.life.time")));
        config.setConnectionTimeout(toInt(environment.getProperty("connection.pool.conn.timeout")));
        dataSource = new HikariDataSource(config);
    }

    /**
     *  This method returns preconfigured datasource
     * @return DataSource
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    private static int toInt(String val) {
        return Integer.parseInt(val);
    }
    private static String prepareDataSourceURL() {
        String dataSourceURL = environment.getProperty("datasource.url.template")
                .replace("URL", environment.getProperty("datasource.url"))
                .replace("PORT", environment.getProperty("datasource.port"))
                .replace("DB_NAME", environment.getProperty("datasource.name"));
        return dataSourceURL;
    }

}
