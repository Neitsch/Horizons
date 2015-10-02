/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.parser;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.extern.slf4j.XSlf4j;

import org.joda.time.LocalTime;

import com.horizons.to.CalendarItem;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 28, 2015
 */
@XSlf4j
public class CourseDataParser {
  private static final Pattern CLASS_TIME_PATTERN =
      Pattern
          .compile("(([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9])-(([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]) ([A-Z]+) ([A-Z]+ [0-9]+)");
  private static final Pattern INSTRUCTOR_PATTERN = Pattern
      .compile("[A-Z][a-z]+ ([A-Z]\\. )+?[A-Z][a-z]+");
  private static final Pattern REQUIREMENTS_PATTERN = Pattern
      .compile("[a-zA-Z\\- ]+(?= GER \\(01cr\\)[,]?)");

  /**
   * @author nschuste
   * @version 1.0.0
   * @param instructor
   * @return
   * @since Oct 1, 2015
   */
  public static Set<String> parseInstructors(final String instructor) {
    return parseGen(instructor, REQUIREMENTS_PATTERN);
  }

  public static Set<String> parseRequirements(final String req) {
    return parseGen(req, REQUIREMENTS_PATTERN);
  }

  public static Set<CalendarItem> parseTime(final String raw) {
    final Matcher m = CLASS_TIME_PATTERN.matcher(raw);
    final Set<CalendarItem> items = new HashSet<>();
    while (m.find()) {
      final Set<CalendarItem> current = new HashSet<>();
      final String days = m.group(5);
      for (final String s : days.split("")) {
        current.add(CalendarItem.builder().day(parseDay(s)).build());
      }
      for (final CalendarItem calendarItem : current) {
        calendarItem.setStart(parseTimeInst(m.group(1)));
        calendarItem.setEnd(parseTimeInst(m.group(3)));
        calendarItem.setLocation(m.group(6));
      }
      items.addAll(current);
    }
    return items;
  }

  /**
   * @author nschuste
   * @version 1.0.0
   * @param s
   * @return
   * @since Sep 30, 2015
   */
  private static DayOfWeek parseDay(final String s) {
    switch (s) {
      case "M":
        return DayOfWeek.MONDAY;
      case "T":
        return DayOfWeek.TUESDAY;
      case "W":
        return DayOfWeek.WEDNESDAY;
      case "R":
        return DayOfWeek.THURSDAY;
      case "F":
        return DayOfWeek.FRIDAY;
    }
    return null;
  }

  private static Set<String> parseGen(final String in, final Pattern pattern) {
    log.entry(in, pattern);
    final Set<String> insts = new HashSet<>();
    final Matcher m = pattern.matcher(in);
    while (m.find()) {
      insts.add(m.group());
    }
    return log.exit(insts);
  }

  /**
   * @author nschuste
   * @version 1.0.0
   * @param group
   * @return
   * @since Sep 30, 2015
   */
  private static LocalTime parseTimeInst(final String group) {
    final int hour = to24Hour(group.split(":")[0]);
    return new LocalTime(hour, Integer.parseInt(group.split(":")[1]));
  }

  /**
   * @author nschuste
   * @version 1.0.0
   * @param split
   * @return
   * @since Sep 30, 2015
   */
  private static int to24Hour(final String split) {
    final int num = Integer.parseInt(split);
    return num <= 7 ? num + 12 : num;
  }
}
