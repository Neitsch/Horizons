/**
 * Copyright 2015 Nigel Schuster.
 */


package com.schuster.service;

import java.util.UUID;

import com.schuster.entities.Instructor;
import com.schuster.generics.GenericDao;
import com.schuster.generics.UUIDGenericService;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
public class InstructorService extends UUIDGenericService<Instructor> {

  /**
   * @author nschuste
   * @version 1.0.0
   * @param genericDao
   * @since Sep 22, 2015
   */
  public InstructorService(final GenericDao<Instructor, UUID> genericDao) {
    super(genericDao);
  }
}
