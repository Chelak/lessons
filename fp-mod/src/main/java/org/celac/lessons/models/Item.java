package org.celac.lessons.models;

public record Item(Long id, String name, ItemData data) {
  @Override
  public String toString() {
    return "Item{" + "id=" + id + ", name='" + name + '\'' + ", data=" + data + '}';
  }
}
