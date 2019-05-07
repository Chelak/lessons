package com.celac.jdbc.app.entities;

public class User {
    private Long id;
    private String userName;
    private String password;
    private Boolean accountLocked;
    private UserRole role;
    private UserProfile userProfile;

    public User() {
    }

    public User(long id, boolean account_locked, String password, String user_name) {
        this.id = id;
        this.accountLocked = account_locked;
        this.password = password;
        this.userName = user_name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(Boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
