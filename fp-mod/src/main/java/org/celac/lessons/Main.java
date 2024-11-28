package org.celac.lessons;

import org.celac.lessons.service.impl.ItemServiceImp;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    new ItemServiceImp()
        .loadAndConsumeItems(
            // on this step via lambda is described how to consume result
            response -> {
              response.ifPresent(System.out::println);
            });
  }
}
