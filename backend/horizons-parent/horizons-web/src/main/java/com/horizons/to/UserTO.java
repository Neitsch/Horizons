/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.to;

import lombok.Data;
import lombok.ToString;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 27, 2015
 */
@Data
@ToString(exclude = "password")
public class UserTO {
  public static final String SessionIdentifier = "SESSID";
  private String password;
  private String username;
}
