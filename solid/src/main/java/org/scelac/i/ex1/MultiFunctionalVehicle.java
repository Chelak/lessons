package org.scelac.i.ex1;

public class MultiFunctionalVehicle implements TransportUnit {
  @Override
  public void drive() {
    System.out.println("Drive");
  }

  @Override
  public void fly() {
    System.out.println("Fly");
  }

  @Override
  public void sail() {
    System.out.println("Navigate");
  }
}
