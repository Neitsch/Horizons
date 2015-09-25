/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.service.impl;

import lombok.extern.slf4j.XSlf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horizons.dao.UserDao;
import com.horizons.entities.User;
import com.horizons.service.UserService;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 23, 2015
 */
@Service
@XSlf4j
public class UserServiceImpl implements UserService {
  @Autowired
  private UserDao dao;

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.horizons.service.UserService#findByName(java.lang.String)
   * @since Sep 24, 2015
   */
  @Override
  public User findByName(final String username) {
    log.entry(username);
    return log.exit(this.dao.findByName(username));
  }
}
