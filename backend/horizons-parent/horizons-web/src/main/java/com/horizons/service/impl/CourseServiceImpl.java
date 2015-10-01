/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.service.impl;

import java.util.Arrays;

import lombok.extern.slf4j.XSlf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horizons.dao.CourseDao;
import com.horizons.dao.DepartmentDao;
import com.horizons.entities.Course;
import com.horizons.entities.Department;
import com.horizons.service.CourseService;
import com.horizons.to.CourseRaw;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 23, 2015
 */
@Service
@XSlf4j
public class CourseServiceImpl implements CourseService {
  @Autowired
  private CourseDao dao;
  @Autowired
  private DepartmentDao departmentDao;

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.horizons.service.CourseInstanceService#persistRawCourse(com.horizons.to.CourseRaw)
   * @since Sep 28, 2015
   */
  @Override
  public void persistRawCourse(final CourseRaw rawCourse) {
    log.entry(rawCourse);
    final String departmentName = rawCourse.getCourse().split(" ")[0];
    final Department department = this.departmentDao.findByShortName(departmentName);
    final Course course = new Course();
    course.setDepartment(Arrays.asList(department));
    log.exit();
  }
}
