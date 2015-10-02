/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.horizons.dao.InstructorDao;
import com.horizons.entities.Instructor;
import com.horizons.generics.GenericDaoImpl;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
@Repository
public class InstructorDaoImpl extends GenericDaoImpl<Instructor> implements InstructorDao {
  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.horizons.dao.InstructorDao#findByName(java.lang.String)
   * @since Oct 1, 2015
   */
  @Override
  public Instructor findByName(final String instructor) {
    return (Instructor) this.getCriteriaForClass().add(Restrictions.eq("name", instructor))
        .uniqueResult();
  }
}
