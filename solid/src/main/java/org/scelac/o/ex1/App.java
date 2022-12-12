package org.scelac.o.ex1;

import java.util.Arrays;
import java.util.List;

public class App {
  public static void main(String[] args) {

      List<ComputerMonitor> monitors = Arrays.asList(
              new ComputerMonitor ( "Samsung S345", Screen.CURVED_SCREEN,  MonitorType.OLED),
              new ComputerMonitor ( "Philips P532", Screen.WIDE_SCREEN,  MonitorType.LCD ),
              new ComputerMonitor ( "LG L888", Screen.WIDE_SCREEN,  MonitorType.LED ),
              new ComputerMonitor ( "Samsung S999", Screen.WIDE_SCREEN,  MonitorType.OLED ),
              new ComputerMonitor ( "Dell D2J47", Screen.CURVED_SCREEN,  MonitorType.LCD )
      );

      List<ComputerMonitor> lcdMonitors =  MonitorFilter.filterByType(monitors,MonitorType.LCD);


      lcdMonitors.forEach( lcd -> System.out.println(lcd.toString()));

  }
}
