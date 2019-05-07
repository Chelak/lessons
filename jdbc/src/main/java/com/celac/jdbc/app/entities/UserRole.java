package com.celac.jdbc.app.entities;

public class UserRole {
    private Long id;
    private String roleName;

    public UserRole(Long id) {
        this.id = id;
    }

    public UserRole() {
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
