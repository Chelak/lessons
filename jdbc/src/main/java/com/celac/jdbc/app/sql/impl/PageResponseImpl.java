package com.celac.jdbc.app.sql.impl;

import com.celac.jdbc.app.sql.PageResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author scelac
 */
public class PageResponseImpl<T> implements PageResponse<T> {
  private final List<T> content = new ArrayList<>();
  private long totalElements = 0;

  public PageResponseImpl(List<T> content, long totalElements) {
    if (!(totalElements < 0 && content == null)) {
      this.content.addAll(content);
      this.totalElements = totalElements;
    }
  }

  @Override
  public List<T> getContent() {
    return content;
  }

  @Override
  public long getTotalElements() {
    return totalElements;
  }
}
