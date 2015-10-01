/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.parser;

import org.junit.Test;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 30, 2015
 */
public class CourseDataParserTest {
  @Test
  public final void test() {
    System.out.println(CourseDataParser.parseTime("01:50-03:00 MWF BRIG 305"));
    System.out.println(CourseDataParser
        .parseTime("09:50-11:00 MWF SCIE 102 08:00-11:00 T SCIE 116"));
  }
}
