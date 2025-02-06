package com.celac.jdbc.app.entities;

import com.celac.jdbc.app.entities.enums.TaskStatus;

import java.io.Serializable;

public class Task implements Serializable {
  private Long id;
  private String title;
  private String description;
  private TaskStatus status;
  private User owner;

  public Task(Long id, String title, String description, TaskStatus status) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public TaskStatus getStatus() {
    return status;
  }

  public User getOwner() {
    return owner;
  }
}
