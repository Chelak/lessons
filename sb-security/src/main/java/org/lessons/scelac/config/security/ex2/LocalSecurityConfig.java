package org.lessons.scelac.config.security.ex2;

import org.lessons.scelac.config.security.ex2.jwt.JwtAuthenticationOncePerRequestFilter;
import org.lessons.scelac.config.security.ex2.jwt.JwtTokenProvider;
import org.lessons.scelac.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author scelac
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
/*
  PreAuthorize not working on Controller solution is @EnableGlobalMethodSecurity(prePostEnabled = true)
  A common problem with using PrePost annotations on controllers is that Spring method security is based on Spring AOP,
  which is by default implemented with JDK proxies.
  That means that it works fine on the service layer which is injected in controller layer as interfaces,
  but it is ignored on controller layer because controller generally do not implement interfaces.
  The following is just my opinion:
     - preffered way: move the pre post annotation on service layer
     - if you cannot (or do not want to), try to have your controller implement an interface containing all the annotated methods
     - as a last way, use proxy-target-class=true
* */
public class LocalSecurityConfig {
  private static final String[] AUTH_WHITELIST = {"/api/login", "/ui/"};
  private final CustomUserDetailsService customUserDetailsService;
  private final JwtTokenProvider tokenProvider;

  public LocalSecurityConfig(CustomUserDetailsService customUserDetailsService, JwtTokenProvider tokenProvider) {
    this.customUserDetailsService = customUserDetailsService;
    this.tokenProvider = tokenProvider;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(5);
  }

  @Bean
  public DaoAuthenticationProvider authProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(customUserDetailsService);
    authProvider.setPasswordEncoder(passwordEncoder());
    return authProvider;
  }

  @Bean
  public AuthenticationManager authManager(HttpSecurity http) throws Exception {
    return http.getSharedObject(AuthenticationManagerBuilder.class)
        .authenticationProvider(authProvider())
        .build();
  }
  @Bean
  public JwtAuthenticationOncePerRequestFilter authenticationJwtTokenFilter() {
    return new JwtAuthenticationOncePerRequestFilter(tokenProvider,customUserDetailsService);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable()).cors().disable()
        .authorizeRequests()
        .antMatchers(AUTH_WHITELIST).permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }
}
