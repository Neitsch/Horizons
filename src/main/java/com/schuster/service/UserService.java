/**
 * Copyright 2015 Nigel Schuster.
 */


package com.schuster.service;

import com.schuster.entities.User;
import com.schuster.generics.GenericDao;
import com.schuster.generics.GenericServiceImpl;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
public class UserService extends GenericServiceImpl<User> {

  /**
   * @author nschuste
   * @version 1.0.0
   * @param genericDao
   * @since Sep 22, 2015
   */
  public UserService(final GenericDao<User> genericDao) {
    super(genericDao);
  }
}
