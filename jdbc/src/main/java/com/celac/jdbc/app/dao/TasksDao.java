package com.celac.jdbc.app.dao;

import com.celac.jdbc.app.entities.Task;
import com.celac.jdbc.app.entities.enums.TaskStatus;

import java.util.List;

public interface TasksDao extends Operations<Task> {
  List<Task> getUsersTask(Long userId);

  List<Task> getUsersTaskByStatus(Long userId, TaskStatus status);
}
