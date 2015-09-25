/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.web;

import java.util.Arrays;
import java.util.List;

import lombok.Data;
import lombok.extern.slf4j.XSlf4j;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 24, 2015
 */
@RestController
@XSlf4j
@RequestMapping("/authz")
public class Authentication {
  @Data
  public static class User {
    String password;
    String username;
  }

  private static final List<GrantedAuthority> authorities;
  static {
    authorities = Arrays.asList(new SimpleGrantedAuthority("USER"));
  }

  @RequestMapping("/auth")
  @javax.annotation.security.RolesAllowed("ROLE_USERR")
  public String authenticated() {
    return "hi";
  }

  @RequestMapping("/login")
  public void login(@RequestBody final User user) {
    log.entry(user);
    final org.springframework.security.core.Authentication authentication =
        new UsernamePasswordAuthenticationToken(user, null, authorities);
    log.debug("Logging in with {}", authentication.getPrincipal());
    SecurityContextHolder.getContext().setAuthentication(authentication);
    log.exit();
  }
}
