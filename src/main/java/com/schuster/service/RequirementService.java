/**
 * Copyright 2015 Nigel Schuster.
 */


package com.schuster.service;

import com.schuster.entities.Requirement;
import com.schuster.generics.GenericDao;
import com.schuster.generics.GenericServiceImpl;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
public class RequirementService extends GenericServiceImpl<Requirement> {

  /**
   * @author nschuste
   * @version 1.0.0
   * @param genericDao
   * @since Sep 22, 2015
   */
  public RequirementService(final GenericDao<Requirement> genericDao) {
    super(genericDao);
  }
}
