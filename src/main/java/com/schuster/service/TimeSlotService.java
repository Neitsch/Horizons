/**
 * Copyright 2015 Nigel Schuster.
 */


package com.schuster.service;

import java.util.UUID;

import com.schuster.entities.TimeSlot;
import com.schuster.generics.GenericDao;
import com.schuster.generics.UUIDGenericService;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
public class TimeSlotService extends UUIDGenericService<TimeSlot> {

  /**
   * @author nschuste
   * @version 1.0.0
   * @param genericDao
   * @since Sep 22, 2015
   */
  public TimeSlotService(final GenericDao<TimeSlot, UUID> genericDao) {
    super(genericDao);
  }
}
