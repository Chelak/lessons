package com.celac.jdbc.app.dao.impl;

import com.celac.jdbc.app.dao.TasksDao;
import com.celac.jdbc.app.dao.mappers.TaskMapper;
import com.celac.jdbc.app.entities.Task;
import com.celac.jdbc.app.entities.enums.TaskStatus;

import com.celac.jdbc.app.sql.impl.ResultSetProcessorImpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.sql.DataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author scelac
 */
public class TasksDaoImpl extends AbstractDAO<Task> implements TasksDao {
  private final static Logger logger = LogManager.getLogger(TasksDaoImpl.class);
  public TasksDaoImpl(DataSource dataSource) {
    super(dataSource);
  }
  @Override
  public Task findOne(Long id) {
    String sql = "select t.* from tasks t where u.id = ?";
     try (Statement statement = getConnection().createStatement();
          ResultSet result = statement.executeQuery(sql)){
       return new ResultSetProcessorImpl<>(result, new TaskMapper()).process();
     }  catch (SQLException e) {
       logger.error(e.getMessage(), e);
       return null;
     }
  }
  @Override
  public List<Task> getUsersTask(Long userId) {
    return null;
  }

  @Override
  public List<Task> getUsersTaskByStatus(Long userId, TaskStatus status) {
    return null;
  }
}
