package org.scelac.o.ex2;

import java.util.List;

public interface IFilter <T> {
    List<T> filter(List<T> listForFiltering, Specification<T> specification);
}
