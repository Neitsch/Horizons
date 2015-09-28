/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.security.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.XSlf4j;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.horizons.security.AuthenticationProvider;
import com.horizons.to.UserTO;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 27, 2015
 */
@Service
@XSlf4j
public class AuthenticationProviderImpl implements AuthenticationProvider {

  private static final List<GrantedAuthority> authorities;
  static {
    authorities = Arrays.asList(new SimpleGrantedAuthority("USER"));
  }

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.horizons.security.AuthenticationProvider#doLogin()
   * @since Sep 27, 2015
   */
  @Override
  public void doLogin(final UserTO user) {
    try {
      final Response res =
          Jsoup.connect("https://bannerweb.lawrence.edu/pls/voyager/twbkwbis.P_ValLogin")
              .data("sid", user.getUsername(), "PIN", user.getPassword()).cookie("TESTID", "SET")
              .method(Method.POST).execute();
      final Map<String, String> cookies = res.cookies();
      final org.springframework.security.core.Authentication authentication =
          new UsernamePasswordAuthenticationToken(user, cookies.get(UserTO.SessionIdentifier),
              authorities);
      SecurityContextHolder.getContext().setAuthentication(authentication);
    } catch (final IOException e) {
      log.catching(e);
    }
  }
}
