package com.celac.jdbc.app.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Result Set row mapper
 * @author scelac
 */
public interface ResultSetRowMapper<T> {
    T mapRow(ResultSet rs) throws SQLException;
}
