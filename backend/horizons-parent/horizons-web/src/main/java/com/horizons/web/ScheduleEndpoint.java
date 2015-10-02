/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.web;

import java.util.Collection;

import lombok.extern.slf4j.XSlf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.horizons.entities.Schedule;
import com.horizons.service.ScheduleService;
import com.horizons.util.ContextUtil;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 27, 2015
 */
@XSlf4j
@RestController
@RequestMapping("/schedule")
public class ScheduleEndpoint {
  @Autowired
  private ScheduleService service;

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.horizons.web.ScheduleEndpoint#all()
   * @since Sep 27, 2015
   */
  @RequestMapping("/all")
  @PreAuthorize(value = "isAuthenticated()")
  public Collection<Schedule> all() {
    log.entry();
    return log.exit(this.service.allSchedulesForUser(ContextUtil.getUsername()));
  }
}
