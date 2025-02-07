package com.celac.jdbc.app.sql.impl;

import com.celac.jdbc.app.sql.PageRequest;

/**
 * @author scelac
 */
public class PageRequestImpl implements PageRequest {
  private final int pageNumber;
  private final int pageSize;

  public PageRequestImpl(int pageNumber, int pageSize) {
    this.pageNumber = pageNumber;
    this.pageSize = pageSize;
  }

  @Override
  public int getPageNumber() {
    return pageNumber;
  }

  @Override
  public int getPageSize() {
    return pageSize;
  }

  @Override
  public int getOffset() {
    return pageNumber * pageSize;
  }
}
