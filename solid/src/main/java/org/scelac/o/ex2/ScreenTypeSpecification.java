package org.scelac.o.ex2;

import org.scelac.o.ex1.ComputerMonitor;
import org.scelac.o.ex1.Screen;

public class ScreenTypeSpecification implements Specification<ComputerMonitor>{

    private final Screen screen;

    public ScreenTypeSpecification(Screen screen) {
        this.screen = screen;
    }

    @Override
    public boolean isSatisfied(ComputerMonitor item) {
        return  screen.equals(item.getScreen());
    }
}
