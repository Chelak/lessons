package org.lessons.scelac.model;

import org.lessons.scelac.model.enums.RoleName;

import java.io.Serializable;


public class UserRole implements Serializable {
   private Long id;
    private RoleName roleName;

    public UserRole() {
    }

    public UserRole(Long id, RoleName roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
}
