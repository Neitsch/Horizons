/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.service.impl;

import lombok.extern.slf4j.XSlf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horizons.dao.DepartmentDao;
import com.horizons.entities.Department;
import com.horizons.service.DepartmentService;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 23, 2015
 */
@Service
@XSlf4j
public class DepartmentServiceImpl implements DepartmentService {
  @Autowired
  private DepartmentDao dao;

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.horizons.service.DepartmentService#ensureDepartmentExists(java.lang.String,
   *      java.lang.String)
   * @since Sep 28, 2015
   */
  @Override
  public void ensureDepartmentExists(final String longName, final String shortName) {
    log.entry(longName, shortName);
    final Department dep = this.dao.findByShortName(shortName);
    if (dep == null) {
      this.dao.create(Department.builder().name(longName).shortName(shortName).build());
    }
    log.exit();
  }
}
