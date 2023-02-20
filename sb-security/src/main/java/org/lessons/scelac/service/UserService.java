package org.lessons.scelac.service;

import org.lessons.scelac.dto.RegisterUserDTO;
import org.lessons.scelac.model.User;

/**
 * @author scelac
 */
public interface UserService {
    User getUserById(Long userId);
    boolean existsByEmail(String email);

    User save(RegisterUserDTO registerUser);
}
