/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.dao;

import com.horizons.entities.User;
import com.horizons.generics.GenericDao;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
public interface UserDao extends GenericDao<User> {

  /**
   * @author nschuste
   * @version 1.0.0
   * @param username
   * @return
   * @since Sep 24, 2015
   */
  public User findByName(String username);

}
