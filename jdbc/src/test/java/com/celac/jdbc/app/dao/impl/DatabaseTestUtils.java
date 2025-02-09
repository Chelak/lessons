package com.celac.jdbc.app.dao.impl;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import javax.sql.DataSource;
import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;

/**
 * @author scelac
 */
public class DatabaseTestUtils {
    private static final String JDBC_URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    private static final HikariDataSource dataSource;
    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(JDBC_URL); // In-memory DB
        config.setUsername(USER );
        config.setPassword(PASSWORD);
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);
        config.setIdleTimeout(30000);
        config.setMaxLifetime(1800000);
        config.setConnectionTimeout(3000);

        dataSource = new HikariDataSource(config);
    }

    public static DataSource getConnection() {
        return  dataSource;
    }

    public static void runMigrations() {
        try (Connection conn = getConnection().getConnection()) {
            Liquibase liquibase = new Liquibase(
                    "db/changelog.xml"
                    , new ClassLoaderResourceAccessor()
                    , new JdbcConnection(conn)
            );
            liquibase.update("");
        } catch (Exception e) {
            throw new RuntimeException("Failed to run Liquibase migrations", e);
        }
    }
}
