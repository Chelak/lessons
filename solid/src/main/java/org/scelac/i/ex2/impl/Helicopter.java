package org.scelac.i.ex2.impl;

import org.scelac.i.ex2.Aircraft;

public class Helicopter implements Aircraft {
    @Override
    public void fly() {
        System.out.println("Fly");
    }
}
