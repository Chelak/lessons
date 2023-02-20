package org.lessons.scelac.dao;

import org.lessons.scelac.model.UserRole;
import org.lessons.scelac.model.enums.RoleName;

/**
 * @author scelac
 */
public interface UserRoleDao {
    UserRole findByRoleName(RoleName guest);
}
