/**
 * Copyright 2015 Nigel Schuster.
 */


package com.schuster.service;

import com.schuster.entities.Term;
import com.schuster.generics.GenericDao;
import com.schuster.generics.GenericServiceImpl;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
public class TermService extends GenericServiceImpl<Term> {

  /**
   * @author nschuste
   * @version 1.0.0
   * @param genericDao
   * @since Sep 22, 2015
   */
  public TermService(final GenericDao<Term> genericDao) {
    super(genericDao);
  }
}
