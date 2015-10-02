/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.dao;

import com.horizons.entities.Instructor;
import com.horizons.generics.GenericDao;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
public interface InstructorDao extends GenericDao<Instructor> {

  /**
   * @author nschuste
   * @version 1.0.0
   * @param instructor
   * @return
   * @since Oct 1, 2015
   */
  Instructor findByName(String instructor);

}
