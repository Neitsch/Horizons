/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.service;

import java.util.Collection;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import com.horizons.entities.Course;
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
   * @return
   * @since Oct 2, 2015
   */
  @Transactional(readOnly = true)
  @Cacheable(value = "allCourses")
  Collection<Course> getAllCourses();

  /**
   * @author nschuste
   * @version 1.0.0
   * @param rawCourse
   * @since Sep 28, 2015
   */
  @Transactional(readOnly = false)
  void persistRawCourse(CourseRaw rawCourse);
}
