/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.horizons.dao.DepartmentDao;
import com.horizons.entities.Department;
import com.horizons.generics.GenericDaoImpl;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
@Repository
public class DepartmentDaoImpl extends GenericDaoImpl<Department> implements DepartmentDao {
  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.horizons.dao.DepartmentDao#findByShortName(java.lang.String)
   * @since Sep 28, 2015
   */
  @Override
  public Department findByShortName(final String departmentName) {
    return (Department) this.getCriteriaForClass()
        .add(Restrictions.eq("shortName", departmentName)).uniqueResult();
  }
}
