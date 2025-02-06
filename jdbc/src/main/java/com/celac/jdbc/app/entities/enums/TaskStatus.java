package com.celac.jdbc.app.entities.enums;

import java.util.stream.Stream;

public enum TaskStatus {
  OPEN("OPEN"),
  CLOSE("CLOSE"),
  PENDING("PENDING"),
  BLOCKED("BLOCKED"),
  IN_PROGRESS("IN_PROGRESS");

  private final String value;

  TaskStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
  public static TaskStatus fromValue(String value) {
    for (TaskStatus t : TaskStatus.values()) {
      if (t.value.equals(value)) {
        return t;
      }
    }
    return null;
  }
}
