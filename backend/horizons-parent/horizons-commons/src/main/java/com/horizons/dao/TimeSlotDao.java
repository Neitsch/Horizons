/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.dao;

import java.time.DayOfWeek;

import org.joda.time.LocalTime;

import com.horizons.entities.TimeSlot;
import com.horizons.generics.GenericDao;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
public interface TimeSlotDao extends GenericDao<TimeSlot> {

  /**
   * @author nschuste
   * @version 1.0.0
   * @param day
   * @param start
   * @param end
   * @return
   * @since Oct 1, 2015
   */
  TimeSlot findByDayAndTime(DayOfWeek day, LocalTime start, LocalTime end);

}
