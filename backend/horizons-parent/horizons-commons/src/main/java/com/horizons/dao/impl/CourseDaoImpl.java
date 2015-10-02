/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.horizons.dao.CourseDao;
import com.horizons.entities.Course;
import com.horizons.entities.Department;
import com.horizons.entities.Term;
import com.horizons.generics.GenericDaoImpl;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
@Repository
public class CourseDaoImpl extends GenericDaoImpl<Course> implements CourseDao {
  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.horizons.dao.CourseDao#findByDepNumTerm(com.horizons.entities.Department, int,
   *      com.horizons.entities.Term)
   * @since Oct 1, 2015
   */
  @Override
  public Course findByDepNumTerm(final Department next, final int courseNumber, final Term term) {
    return (Course) this.getCriteriaForClass().createAlias("department", "dep")
        .add(Restrictions.eq("dep.uuid", next.getUuid()))
        .add(Restrictions.eq("courseNumber", courseNumber)).add(Restrictions.eq("term", term))
        .uniqueResult();
  }
}
