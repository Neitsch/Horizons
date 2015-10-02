/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.dao;

import com.horizons.entities.Course;
import com.horizons.entities.Department;
import com.horizons.entities.Term;
import com.horizons.generics.GenericDao;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
public interface CourseDao extends GenericDao<Course> {

  /**
   * @author nschuste
   * @version 1.0.0
   * @param next
   * @param courseNumber
   * @param term
   * @return
   * @since Oct 1, 2015
   */
  Course findByDepNumTerm(Department next, int courseNumber, Term term);

}
