package org.celac.lessons.models;

public record ItemData(String color, String capacity) {
  @Override
  public String toString() {
    return "ItemData{" + "color='" + color + '\'' + ", capacity='" + capacity + '\'' + '}';
  }
}
