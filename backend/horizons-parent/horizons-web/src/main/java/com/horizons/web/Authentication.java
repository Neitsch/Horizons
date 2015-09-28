/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.web;

import lombok.extern.slf4j.XSlf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.horizons.security.AuthenticationProvider;
import com.horizons.to.UserTO;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 24, 2015
 */
@RestController
@XSlf4j
@RequestMapping("/authz")
public class Authentication {
  @Autowired
  AuthenticationProvider authenticator;

  @RequestMapping("/auth")
  @PreAuthorize(value = "hasRole('ROLE_USER')")
  public String authenticated() {
    return "hi";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  @PreAuthorize("permitAll")
  public void login(@RequestBody final UserTO user) {
    log.entry(user);
    this.authenticator.doLogin(user);
    System.out.println(SecurityContextHolder.getContext().getAuthentication().getCredentials());
    log.exit();
  }
}
