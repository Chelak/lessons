package org.lessons.scelac.model.enums;

public enum RoleName {
  GUEST("GUEST"),
  ADMIN("ADMIN"),
  PRODUCT_MANAGER("PRODUCT_MANAGER"),
  SCRUM_MASTER("SCRUM_MASTER"),
  TESTER("TESTER"),
  DEVELOPER("DEVELOPER");

  private String role;

  RoleName(String role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return this.role;
  }
}
