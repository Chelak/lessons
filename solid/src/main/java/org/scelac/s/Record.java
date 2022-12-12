package org.scelac.s;

import java.util.Date;

public interface Record {
  String getStringField();

  public Date getDateField();

  public Double getDoubleField();

  public Integer getIntegerField();
}
