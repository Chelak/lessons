package org.scelac.o.ex2;

import org.scelac.o.ex1.ComputerMonitor;
import org.scelac.o.ex1.MonitorType;

public class MonitorTypeSpecification implements Specification<ComputerMonitor>{
    private final MonitorType monitorType;

    public MonitorTypeSpecification(MonitorType monitorType) {
        this.monitorType = monitorType;
    }

    @Override
    public boolean isSatisfied(ComputerMonitor item) {
        return monitorType.equals(item.getMonitorType());
    }
}
