/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.dao.impl;

import java.time.DayOfWeek;

import lombok.extern.slf4j.XSlf4j;

import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalTime;
import org.springframework.stereotype.Repository;

import com.horizons.dao.TimeSlotDao;
import com.horizons.entities.TimeSlot;
import com.horizons.generics.GenericDaoImpl;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
@Repository
@XSlf4j
public class TimeSlotDaoImpl extends GenericDaoImpl<TimeSlot> implements TimeSlotDao {

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.horizons.dao.TimeSlotDao#findByDayAndTime(java.time.DayOfWeek,
   *      org.joda.time.LocalTime, org.joda.time.LocalTime)
   * @since Oct 1, 2015
   */
  @Override
  public TimeSlot findByDayAndTime(final DayOfWeek day, final LocalTime start, final LocalTime end) {
    return (TimeSlot) this.getCriteriaForClass().add(Restrictions.eq("weekDay", day))
        .add(Restrictions.eq("start", start)).add(Restrictions.eq("end", end)).uniqueResult();
  }
}
