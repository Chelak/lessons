package org.scelac.o.ex1;

public class ComputerMonitor {
    private String name;
    private MonitorType monitorType;
    private Screen screen;

    public ComputerMonitor(String name, Screen screen, MonitorType monitorType) {
        this.name = name;
        this.monitorType = monitorType;
        this.screen = screen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MonitorType getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(MonitorType monitorType) {
        this.monitorType = monitorType;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    @Override
    public String toString() {
        return "ComputerMonitor{" +
                "name='" + name + '\'' +
                ", monitorType=" + monitorType +
                ", screen=" + screen +
                '}';
    }
}
