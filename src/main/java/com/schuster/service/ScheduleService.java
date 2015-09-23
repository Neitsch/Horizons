/**
 * Copyright 2015 Nigel Schuster.
 */


package com.schuster.service;

import java.util.UUID;

import com.schuster.entities.Schedule;
import com.schuster.generics.GenericDao;
import com.schuster.generics.UUIDGenericService;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
public class ScheduleService extends UUIDGenericService<Schedule> {

  /**
   * @author nschuste
   * @version 1.0.0
   * @param genericDao
   * @since Sep 22, 2015
   */
  public ScheduleService(final GenericDao<Schedule, UUID> genericDao) {
    super(genericDao);
  }
}
