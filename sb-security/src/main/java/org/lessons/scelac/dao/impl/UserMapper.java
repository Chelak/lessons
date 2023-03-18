package org.lessons.scelac.dao.impl;



import org.lessons.scelac.model.User;
import org.lessons.scelac.model.UserRole;
import org.lessons.scelac.model.enums.RoleName;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("u_id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setUserName(rs.getString("user_name"));
        user.setAccountLocked(!rs.getBoolean("enabled"));
        user.setPassword(rs.getString("password"));

        UserRole userRole = new UserRole();
        userRole.setId(rs.getLong("r_id"));
        userRole.setRoleName( RoleName.valueOf(rs.getString("role_name")));
        user.setRoles(Arrays.asList(userRole));
        return user;
    }
}
