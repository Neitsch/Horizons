/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.horizons.dao.TermDao;
import com.horizons.entities.Term;
import com.horizons.generics.GenericDaoImpl;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
@Repository
public class TermDaoImpl extends GenericDaoImpl<Term> implements TermDao {
  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.horizons.dao.TermDao#findByName(java.lang.String)
   * @since Oct 1, 2015
   */
  @Override
  public Term findByName(final String term) {
    return (Term) this.getCriteriaForClass().add(Restrictions.eq("name", term)).uniqueResult();
  }
}
