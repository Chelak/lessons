package org.scelac.o.ex2;

import org.scelac.o.ex1.ComputerMonitor;

import java.util.List;
import java.util.stream.Collectors;

public class MonitorFilter2 implements IFilter<ComputerMonitor>{
    @Override
    public List<ComputerMonitor> filter(List<ComputerMonitor> listForFiltering, Specification<ComputerMonitor> specification) {
        return  listForFiltering.stream().filter(el -> specification.isSatisfied(el)).collect(Collectors.toList());
    }
}
