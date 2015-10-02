/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.dao;

import com.horizons.entities.Term;
import com.horizons.generics.GenericDao;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
public interface TermDao extends GenericDao<Term> {

  /**
   * @author nschuste
   * @version 1.0.0
   * @param term
   * @return
   * @since Oct 1, 2015
   */
  Term findByName(String term);

}
