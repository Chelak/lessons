package com.celac.jdbc.app.sql;

/**
 * For request of slice of data from db
 *
 * @author scelac
 */
public interface PageRequest {

  /**
   * Returns the page to be returned
   *
   * @return int
   */
  int getPageNumber();

  /**
   * number of items to be returned.
   *
   * @return int
   */
  int getPageSize();

  /**
   * Returns the offset to be taken according to the underlying page and page size.
   *
   * @return int
   */
  int getOffset();
}
