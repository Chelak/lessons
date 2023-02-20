package org.lessons.scelac.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.Serializable;

/**
 * @author scelac
 */
public abstract class AbstractDao <T extends Serializable> {
    private JdbcTemplate jdbcTemplate;

    public AbstractDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
