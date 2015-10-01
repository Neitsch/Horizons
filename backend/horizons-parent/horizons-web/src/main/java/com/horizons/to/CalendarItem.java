/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.to;

import java.time.DayOfWeek;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.joda.time.LocalTime;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 30, 2015
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CalendarItem {
  private DayOfWeek day;
  private LocalTime end;
  private String location;
  private LocalTime start;
}
