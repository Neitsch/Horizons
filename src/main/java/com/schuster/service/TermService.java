/**
 * Copyright 2015 Nigel Schuster.
 */


package com.schuster.service;

import java.util.UUID;

import com.schuster.entities.Term;
import com.schuster.generics.GenericDao;
import com.schuster.generics.UUIDGenericService;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
public class TermService extends UUIDGenericService<Term> {

  /**
   * @author nschuste
   * @version 1.0.0
   * @param genericDao
   * @since Sep 22, 2015
   */
  public TermService(final GenericDao<Term, UUID> genericDao) {
    super(genericDao);
  }
}
