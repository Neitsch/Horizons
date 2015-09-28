/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.security;

import com.horizons.to.UserTO;


/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 27, 2015
 */
public interface AuthenticationProvider {
  public void doLogin(UserTO user);
}
