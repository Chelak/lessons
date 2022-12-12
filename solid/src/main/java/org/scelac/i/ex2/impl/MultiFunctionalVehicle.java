package org.scelac.i.ex2.impl;

import org.scelac.i.ex2.Aircraft;
import org.scelac.i.ex2.Ship;
import org.scelac.i.ex2.Vehicle;

public class MultiFunctionalVehicle implements Aircraft, Ship, Vehicle {
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
