package org.scelac.d.ex2;

import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    Shelf shelf = new Shelf( new ArrayList<>());
    shelf.addProduct(new Book());
    shelf.addProduct(new VideoContent());
  }
}
