package org.lessons.scelac.config.security;


import org.lessons.scelac.model.UserRole;
import org.lessons.scelac.model.enums.RoleName;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private List<RoleName> roles;
    private Boolean accountNonLocked;

    private Boolean enabled;


    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails() {
    }

    public CustomUserDetails(Long id, String username, String password,List<UserRole> roleList,
                             Boolean accountNonLocked, Boolean enabled, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = mapTOUserRoleName(roleList);
        this.authorities = mapAuthority(roleList);
        this.accountNonLocked = accountNonLocked;
        this.enabled = enabled;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private List<RoleName> mapTOUserRoleName(List<UserRole> roles) {
        return roles.stream().map(roleName ->
               roleName.getRoleName()
        ).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
     return authorities;
    }

    @Override
    public String getPassword() {
        return  password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    private Collection<? extends GrantedAuthority> mapAuthority(List<UserRole> roleNameList){
       return roleNameList.stream().map(role ->
                new SimpleGrantedAuthority(role.getRoleName().name())
        ).collect(Collectors.toList());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<RoleName> getRoles() {
        return roles;
    }
}
