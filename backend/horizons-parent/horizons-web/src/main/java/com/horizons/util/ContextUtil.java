/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.util;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 27, 2015
 */
public class ContextUtil {
  private ContextUtil() {}

  public static String getUsername() {
    return SecurityContextHolder.getContext().getAuthentication().getName();
  }
}
