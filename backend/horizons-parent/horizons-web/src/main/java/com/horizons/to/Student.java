/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.to;

import java.util.Collection;
import java.util.HashSet;

import lombok.Builder;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonView;
import com.horizons.entities.Course;
import com.horizons.jsonview.AllCoursesView;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Oct 7, 2015
 */
@Data
@Builder
public class Student {
  @JsonView(value = AllCoursesView.class)
  private Collection<Course> courses = new HashSet<>();
}
