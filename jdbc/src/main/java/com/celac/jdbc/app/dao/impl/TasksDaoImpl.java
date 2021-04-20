package com.celac.jdbc.app.dao.impl;

import com.celac.jdbc.app.dao.TasksDao;
import com.celac.jdbc.app.entities.Task;
import com.celac.jdbc.app.entities.enums.TaskStatus;

import java.sql.Connection;
import java.util.List;

public class TasksDaoImpl extends AbstractDAO<Task> implements TasksDao {

  public TasksDaoImpl(Connection dataSourcesConnection) {
    super(dataSourcesConnection);
  }

  @Override
  public Task findOne(Long id) {
    return null;
  }

  @Override
  public List<Task> findAll() {
    return null;
  }

  @Override
  public void create(Task entity) {}

  @Override
  public Task update(Task entity) {
    return null;
  }

  @Override
  public void delete(Task entity) {}

  @Override
  public void deleteById(long entityId) {}

  @Override
  public List<Task> getUsersTask(Long userId) {
    return null;
  }

  @Override
  public List<Task> getUsersTaskByStatus(Long userId, TaskStatus status) {
    return null;
  }
}
