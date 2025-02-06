package com.celac.jdbc.app.sql.impl;

import com.celac.jdbc.app.sql.ResultSetProcessor;
import com.celac.jdbc.app.sql.ResultSetRowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  This should be used when need to map list of row response to list of object
 * @author scelac
 */
public class ResultSetProcessorImpl<T> implements ResultSetProcessor {
    private final ResultSet resultSet;
    private final ResultSetRowMapper<T> rowMapper;

    public ResultSetProcessorImpl(ResultSet resultSet, ResultSetRowMapper<T> rowMapper) {
        this.resultSet = resultSet;
        this.rowMapper = rowMapper;
    }
    public T process() throws SQLException {
        return rowMapper.mapRow(resultSet);
    }
}
