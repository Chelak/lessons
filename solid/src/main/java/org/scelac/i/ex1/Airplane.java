package org.scelac.i.ex1;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Airplane implements TransportUnit {
    @Override
    public void drive() {
        throw new NotImplementedException();
    }

    @Override
    public void fly() {

    }

    @Override
    public void sail() {
        throw new NotImplementedException();
    }
}
