/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.dao;

import com.horizons.entities.Requirement;
import com.horizons.entities.Requirement.RequirementEnum;
import com.horizons.generics.GenericDao;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
public interface RequirementDao extends GenericDao<Requirement> {

  /**
   * @author nschuste
   * @version 1.0.0
   * @param requirement
   * @return
   * @since Oct 1, 2015
   */
  Requirement findByClassSpec(String requirement);

  /**
   * @author nschuste
   * @version 1.0.0
   * @param requirement
   * @return
   * @since Oct 1, 2015
   */
  Requirement findByShort(RequirementEnum requirement);

}
