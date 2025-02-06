package com.celac.jdbc.app.dao.mappers;

import com.celac.jdbc.app.entities.Task;
import com.celac.jdbc.app.entities.enums.TaskStatus;
import com.celac.jdbc.app.sql.ResultSetRowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author scelac
 */

public class TaskMapper implements ResultSetRowMapper<Task> {

  @Override
  public Task mapRow(ResultSet rs) throws SQLException {
    Task task = null;
    while (rs.next()) {
      task =
          new Task(
              rs.getLong("id"),
              rs.getString("title"),
              rs.getString("description"),
              TaskStatus.fromValue(rs.getString("status")));
    }
    return task;
  }
}
