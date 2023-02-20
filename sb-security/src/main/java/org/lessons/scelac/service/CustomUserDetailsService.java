package org.lessons.scelac.service;

import org.lessons.scelac.config.security.CustomUserDetails;
import org.lessons.scelac.dao.UserDao;
import org.lessons.scelac.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author scelac
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private final UserDao userDao;

    public CustomUserDetailsService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        final User userAccount = userDao.findByUserName(userName);
        if (userAccount == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        return new CustomUserDetails(userAccount.getId(), userAccount.getUserName(), userAccount.getPassword(),
                userAccount.getRoles(), userAccount.getAccountLocked(), true, userAccount.getFirstName(), userAccount.getLastName());
    }
}
