/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.service;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import com.horizons.entities.Schedule;


/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
public interface ScheduleService {

  /**
   * @author nschuste
   * @version 1.0.0
   * @param username
   * @return
   * @since Sep 27, 2015
   */
  @Transactional(readOnly = true)
  Collection<Schedule> allSchedulesForUser(String username);
}
