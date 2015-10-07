/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.to;

import java.io.Serializable;

import lombok.Data;


/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 28, 2015
 */
@Data
public class CourseRaw implements Serializable {
  private String attributes;
  private String classTime;
  private String course;
  private String crn;
  private String description;
  private String instructor;
  private String prerequisites;
  private String term;
  private String title;
  private String units;
}
