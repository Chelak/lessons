package com.celac.jdbc.app.sql;

import java.sql.SQLException;

/**
 * @author scelac
 */
public interface ResultSetProcessor<T> {
    T process() throws SQLException;
}
