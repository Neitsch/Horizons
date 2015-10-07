/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.web;

import lombok.extern.slf4j.XSlf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.horizons.jsonview.AllCoursesView;
import com.horizons.scraper.StudentScraper;
import com.horizons.to.Student;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Oct 7, 2015
 */
@RestController
@RequestMapping("/student")
@XSlf4j
public class StudentEndpoint {
  @Autowired
  private StudentScraper service;

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.horizons.web.CourseEndpoint#all()
   * @since Oct 2, 2015
   */

  @RequestMapping(value = "/info", method = RequestMethod.GET, produces = "application/json")
  @PreAuthorize(value = "isAuthenticated()")
  @ResponseStatus(value = HttpStatus.OK)
  @JsonView(AllCoursesView.class)
  public Student student() {
    log.entry();
    try {
      return this.service.scrape(SecurityContextHolder.getContext().getAuthentication().getName());
    } catch (final Exception e) {
      log.catching(e);
      return log.exit(null);
    }
  }
}
