package org.scelac.i.ex1;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Car implements TransportUnit {
    @Override
    public void drive() {
        System.out.println("Drive");
    }

    @Override
    public void fly() {
        throw new NotImplementedException();
    }

    @Override
    public void sail() {
        throw new NotImplementedException();
    }
}
