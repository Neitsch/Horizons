/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.horizons.dao.RequirementDao;
import com.horizons.entities.Requirement;
import com.horizons.entities.Requirement.RequirementEnum;
import com.horizons.generics.GenericDaoImpl;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
@Repository
public class RequirementDaoImpl extends GenericDaoImpl<Requirement> implements RequirementDao {
  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.horizons.dao.RequirementDao#findByClassSpec(java.lang.String)
   * @since Oct 1, 2015
   */
  @Override
  public Requirement findByClassSpec(final String requirement) {
    return (Requirement) this.getCriteriaForClass()
        .add(Restrictions.eq("classViewRepresentation", requirement)).uniqueResult();
  }

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.horizons.dao.RequirementDao#findByShort(com.horizons.entities.Requirement.RequirementEnum)
   * @since Oct 1, 2015
   */
  @Override
  public Requirement findByShort(final RequirementEnum requirement) {
    return (Requirement) this.getCriteriaForClass()
        .add(Restrictions.eq("requirement", requirement)).uniqueResult();
  }
}
