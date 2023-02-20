package org.lessons.scelac.dao;

import org.lessons.scelac.model.User;

/**
 * @author scelac
 */
public interface UserDao {
    User getById(Long userId);
    User findByUserName(String userName);

    boolean existsByEmail(String email);

    User save(User user);

}
