package com.celac.anotation.app.services;



public class DefaultMethodChallenge {

  public static void main(String[] args) {


    Circle circle = new Circle() {
        @Override
        public void draw() {
            Circle.super.draw();
        }
    };
    circle.draw();
  }

  public interface Figure {
    default void draw() {
      System.out.println("Figure");
    }
  }

  public interface Circle extends Figure {
    default void draw() {
      System.out.printf("circle ");
    }
  }
}
