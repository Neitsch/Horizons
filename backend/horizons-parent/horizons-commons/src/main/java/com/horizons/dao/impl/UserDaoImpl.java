/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.dao.impl;

import lombok.extern.slf4j.XSlf4j;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.horizons.dao.UserDao;
import com.horizons.entities.User;
import com.horizons.generics.GenericDaoImpl;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
@XSlf4j
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

  /**
   * {@inheritDoc}
   * 
   * @author nschuste
   * @version 1.0.0
   * @see com.horizons.dao.UserDao#findByName(java.lang.String)
   * @since Sep 24, 2015
   */
  @Override
  public User findByName(final String username) {
    log.entry(username);
    final User user =
        (User) this.sessionFactory.getCurrentSession().createCriteria(User.class)
            .add(Restrictions.eq("username", username)).uniqueResult();
    return log.exit(user);
  }
}
