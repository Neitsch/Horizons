/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.service;

import com.horizons.to.CourseRaw;



/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
public interface CourseService {

  /**
   * @author nschuste
   * @version 1.0.0
   * @param rawCourse
   * @since Sep 28, 2015
   */
  void persistRawCourse(CourseRaw rawCourse);
}
