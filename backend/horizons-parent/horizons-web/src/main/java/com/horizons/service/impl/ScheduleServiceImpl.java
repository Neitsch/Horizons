/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.service.impl;

import java.util.Collection;

import lombok.extern.slf4j.XSlf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horizons.dao.ScheduleDao;
import com.horizons.dao.UserDao;
import com.horizons.entities.Schedule;
import com.horizons.entities.User;
import com.horizons.service.ScheduleService;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 23, 2015
 */
@Service
@XSlf4j
public class ScheduleServiceImpl implements ScheduleService {
  @Autowired
  private ScheduleDao dao;
  @Autowired
  private UserDao userDao;

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.horizons.service.ScheduleService#allSchedulesForUser(java.lang.String)
   * @since Sep 27, 2015
   */
  @Override
  public Collection<Schedule> allSchedulesForUser(final String username) {
    log.entry(username);
    final User user = this.userDao.findByName(username);
    return log.exit(user.getSchedules());
  }
}
