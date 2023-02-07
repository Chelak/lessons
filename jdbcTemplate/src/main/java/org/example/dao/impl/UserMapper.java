package org.example.dao.impl;

import org.example.domain.User;
import org.example.domain.UserRole;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        //u.id, u.first_name, u.last_name,u.user_name,u.enabled,u.created_date,u.last_name, r.id,r.role_name
        User user = new User();
        user.setId(rs.getLong("u_id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setLastName(rs.getString("user_name"));
        user.setEnabled(rs.getBoolean("enabled"));
        user.setCreatedDate(rs.getDate("created_date"));
        user.setCreatedDate(rs.getDate("last_login_date"));

        UserRole userRole = new UserRole();
        userRole.setId(rs.getLong("r_id"));
        userRole.setRoleName(rs.getString("role_name"));
        user.setUserRole(userRole);

        return user;
    }
}
