package org.lessons.scelac.dao.impl;

import org.lessons.scelac.model.UserRole;
import org.lessons.scelac.model.enums.RoleName;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author scelac
 */
public class UserRoleRowMapper implements RowMapper<UserRole> {
    @Override
    public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserRole(rs.getLong("id"), RoleName.valueOf(rs.getString("role_name")));
    }
}
