package com.celac.jdbc.app.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
  private Long id;
  private String userName;
  private String firstName;
  private String lastName;
  private List<Task> taskList;
  private UserRole userRole;
  private Boolean enabled;
  private Date createdDate;
  private Date lastLoginDate;

  public User() {}

  public User(Long id, String userName, String firstName, String lastName) {
    this.id = id;
    this.userName = userName;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public UserRole getUserRole() {
    return userRole;
  }

  public void setUserRole(UserRole userRole) {
    this.userRole = userRole;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public Date getLastLoginDate() {
    return lastLoginDate;
  }

  public void setLastLoginDate(Date lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public List<Task> getTaskList() {
    return taskList;
  }

  public void setTaskList(List<Task> taskList) {
    this.taskList = taskList;
  }
}
