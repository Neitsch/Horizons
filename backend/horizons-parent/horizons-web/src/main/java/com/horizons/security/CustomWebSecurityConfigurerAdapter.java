/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 25, 2015
 */
@EnableWebSecurity
@Configuration
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
   * @since Sep 25, 2015
   */
  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    // http.authorizeRequests().antMatchers("/public/**",
    // "/authz/login").permitAll().anyRequest().authenticated().and().csrf().disable();
    http.csrf().disable();
  }
}
