/**
 * Copyright 2015 Nigel Schuster.
 */


package com.schuster.service;

import java.util.UUID;

import com.schuster.entities.Course;
import com.schuster.generics.GenericDao;
import com.schuster.generics.UUIDGenericService;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
public class CourseService extends UUIDGenericService<Course> {

  /**
   * @author nschuste
   * @version 1.0.0
   * @param genericDao
   * @since Sep 22, 2015
   */
  public CourseService(final GenericDao<Course, UUID> genericDao) {
    super(genericDao);
  }
}
