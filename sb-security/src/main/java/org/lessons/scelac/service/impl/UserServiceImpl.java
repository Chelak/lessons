package org.lessons.scelac.service.impl;

import org.lessons.scelac.dao.UserDao;
import org.lessons.scelac.dao.UserRoleDao;
import org.lessons.scelac.dto.RegisterUserDTO;
import org.lessons.scelac.model.User;
import org.lessons.scelac.model.UserRole;
import org.lessons.scelac.model.enums.RoleName;
import org.lessons.scelac.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author scelac
 */
@Service
public class UserServiceImpl implements UserService {

  private final UserDao userDao;
  private final PasswordEncoder passwordEncoder;
  private final UserRoleDao userRoleDao;

  public UserServiceImpl(
      UserDao userDao, PasswordEncoder passwordEncoder, UserRoleDao userRoleDao) {
    this.userDao = userDao;
    this.passwordEncoder = passwordEncoder;
    this.userRoleDao = userRoleDao;
  }

  @Override
  public User getUserById(Long userId) {
    return userDao.getById(userId);
  }

  @Override
  public boolean existsByEmail(String email) {
    return userDao.existsByEmail(email);
  }

  @Override
  public User save(RegisterUserDTO registerUser) {
    User user = new User();
    user.setFirstName(registerUser.getFirstName());
    user.setLastName(registerUser.getLastName());
    user.setAccountLocked(false);
    user.setUserName(registerUser.getEmail());
    user.setPassword(passwordEncoder.encode(registerUser.getPassword()));
    UserRole roleName = userRoleDao.findByRoleName(RoleName.GUEST);
    user.setRoles(Collections.singletonList(roleName));

    return userDao.save(user);
  }
}
