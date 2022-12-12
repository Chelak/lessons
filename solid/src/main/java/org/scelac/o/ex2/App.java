package org.scelac.o.ex2;

import org.scelac.o.ex1.ComputerMonitor;
import org.scelac.o.ex1.MonitorType;
import org.scelac.o.ex1.Screen;

import java.util.Arrays;
import java.util.List;

public class App {
  public static void main(String[] args) {

    List<ComputerMonitor> monitors =
        Arrays.asList(
            new ComputerMonitor("Samsung S345", Screen.CURVED_SCREEN, MonitorType.OLED),
            new ComputerMonitor("Philips P532", Screen.WIDE_SCREEN, MonitorType.LCD),
            new ComputerMonitor("LG L888", Screen.WIDE_SCREEN, MonitorType.LED),
            new ComputerMonitor("Samsung S999", Screen.WIDE_SCREEN, MonitorType.OLED),
            new ComputerMonitor("Dell D2J47", Screen.CURVED_SCREEN, MonitorType.LCD));

    MonitorFilter2 monitorFilter = new MonitorFilter2();

    List<ComputerMonitor> lcdMonitors =
        monitorFilter.filter(monitors, new MonitorTypeSpecification(MonitorType.OLED));
    List<ComputerMonitor> wideScreens = monitorFilter.filter(monitors, new ScreenTypeSpecification(Screen.CURVED_SCREEN));
    // todo filter by Screen type
    // http://www.technical-recipes.com/2021/solid-principles-cheat-sheet-in-c/
    // https://www.monterail.com/hubfs/PDF%20content/SOLID_cheatsheet.pdf
//    lcdMonitors.forEach(lcd -> System.out.println(lcd.toString()));
    wideScreens.forEach(sc -> System.out.println(sc.toString()));
  }
}
