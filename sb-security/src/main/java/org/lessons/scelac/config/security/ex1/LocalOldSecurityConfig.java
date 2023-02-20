package org.lessons.scelac.config.security.ex1;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Note: Spring Security 5.7.0-M2, WebSecurityConfigurerAdapter has been deprecated.
 *
 * @author scelac
 */
//@Configuration
//@EnableWebSecurity
public class LocalOldSecurityConfig extends WebSecurityConfigurerAdapter {

  /** overridden for implementing own Authentication logic */
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {}

  /** overridden for authorization logic, where and who have ACCESS * */
  @Override
  protected void configure(HttpSecurity http) throws Exception {}
}
