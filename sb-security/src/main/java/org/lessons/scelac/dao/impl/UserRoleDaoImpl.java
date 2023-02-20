package org.lessons.scelac.dao.impl;

import org.lessons.scelac.dao.AbstractDao;
import org.lessons.scelac.dao.UserRoleDao;
import org.lessons.scelac.model.UserRole;
import org.lessons.scelac.model.enums.RoleName;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * @author scelac
 */
@Repository
public class UserRoleDaoImpl  extends AbstractDao<UserRole> implements UserRoleDao {
    public UserRoleDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public UserRole findByRoleName(RoleName guest) {
        String sql = "SELECT * FROM user_role WHERE role_name =" +guest.name();
        return getJdbcTemplate().queryForObject(sql,
                new UserRoleRowMapper());
    }
}
