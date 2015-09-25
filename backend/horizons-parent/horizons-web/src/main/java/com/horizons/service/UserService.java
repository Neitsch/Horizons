/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.service;

import org.springframework.transaction.annotation.Transactional;

import com.horizons.entities.User;


/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
public interface UserService {
  @Transactional(readOnly = true)
  public User findByName(String username);
}
