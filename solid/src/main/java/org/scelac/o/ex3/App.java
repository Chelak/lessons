package org.scelac.o.ex3;

import org.scelac.o.ex1.ComputerMonitor;
import org.scelac.o.ex1.MonitorType;
import org.scelac.o.ex1.Screen;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class App {
  public static void main(String[] args) {

    List<ComputerMonitor> monitors =
        Arrays.asList(
            new ComputerMonitor("Samsung S345", Screen.CURVED_SCREEN, MonitorType.OLED),
            new ComputerMonitor("Philips P532", Screen.WIDE_SCREEN, MonitorType.LCD),
            new ComputerMonitor("LG L888", Screen.WIDE_SCREEN, MonitorType.LED),
            new ComputerMonitor("Samsung S999", Screen.WIDE_SCREEN, MonitorType.OLED),
            new ComputerMonitor("Dell D2J47", Screen.CURVED_SCREEN, MonitorType.LCD));

    Predicate<ComputerMonitor> screenFilter = sf -> Screen.CURVED_SCREEN.equals(sf.getScreen());
    Predicate<ComputerMonitor> monitorTypePredicate = mt -> MonitorType.LCD.equals(mt.getMonitorType());

    monitors.stream().filter(screenFilter).forEach(sc -> System.out.println(sc.toString()));

    monitors.stream().filter(monitorTypePredicate).forEach(mt -> System.out.println(mt.toString()));
  }
}
