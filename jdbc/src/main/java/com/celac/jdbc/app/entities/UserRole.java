package com.celac.jdbc.app.entities;

import java.io.Serializable;

public class UserRole implements Serializable {
    private Long  id;
    private String roleName;

    public UserRole() {
    }

    public UserRole(Long id) {
        this.id = id;
    }

    public UserRole(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
