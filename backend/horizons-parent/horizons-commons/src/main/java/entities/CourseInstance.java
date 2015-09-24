/**
 * Copyright 2015 Nigel Schuster.
 */


package com.schuster.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 21, 2015
 */
@Data
@Entity
public class CourseInstance {
  @ManyToOne
  private Course course;
  @ManyToMany
  private Set<Instructor> instructors = new HashSet<>();
  @ManyToMany
  private Set<TimeSlot> slots = new HashSet<>();
  @ManyToOne
  private Term term;
  @Id
  @Column(columnDefinition = "BINARY(16)")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID uuid;
}
