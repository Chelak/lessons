package com.celac.jdbc.app.sql;

import java.util.List;

/**
 * this generic interface is used for page response
 *
 * @author scelac
 */
public interface PageResponse<T> {
  /**
   * Represent list of elements of this page
   *
   * @return List
   */
  List<T> getContent();

  /**
   * total element in the requested table based on how much element was selected by param LIMIT we
   * can calculate how many pages will have
   *
   * @return long
   */
  long getTotalElements();
}
