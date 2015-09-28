/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.web;

import java.util.Collection;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;

import com.horizons.entities.Schedule;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 27, 2015
 */
@RequestMapping("/schedule")
public interface ScheduleEndpoint {

  @RequestMapping("/all")
  @PreAuthorize(value = "isAuthenticated()")
  public Collection<Schedule> all();
}
