/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.dao;

import com.horizons.entities.Department;
import com.horizons.generics.GenericDao;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
public interface DepartmentDao extends GenericDao<Department> {

  /**
   * @author nschuste
   * @version 1.0.0
   * @param departmentName
   * @return
   * @since Sep 28, 2015
   */
  Department findByShortName(String departmentName);

}
