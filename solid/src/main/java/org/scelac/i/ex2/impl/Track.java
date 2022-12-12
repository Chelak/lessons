package org.scelac.i.ex2.impl;

import org.scelac.i.ex2.Vehicle;

public class Track implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Drive");
    }
}
