package org.scelac.o.ex1;

import java.util.List;
import java.util.stream.Collectors;

public final class MonitorFilter {

    MonitorFilter() {
        throw new IllegalStateException("Utility class");
    }

    public static List<ComputerMonitor> filterByType(List<ComputerMonitor> monitors, final MonitorType type) {
       return monitors.stream().filter(m -> m.getMonitorType().equals(type)).collect(Collectors.toList());
    }

    //todo monitor filter by screen type
}
