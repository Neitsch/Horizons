/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.web;

import java.util.Collection;

import lombok.extern.slf4j.XSlf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.horizons.entities.Course;
import com.horizons.jsonview.AllCoursesView;
import com.horizons.service.CourseService;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Oct 2, 2015
 */
@XSlf4j
@RestController
@RequestMapping("/course")
public class CourseEndpoint {
  @Autowired
  private CourseService service;

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.horizons.web.CourseEndpoint#all()
   * @since Oct 2, 2015
   */

  @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
  @PreAuthorize(value = "permitAll()")
  @ResponseStatus(value = HttpStatus.OK)
  @JsonView(AllCoursesView.class)
  public Collection<Course> all() {
    log.entry();
    try {
      return this.service.getAllCourses();
    } catch (final Exception e) {
      log.catching(e);
      return log.exit(null);
    }
  }
}
