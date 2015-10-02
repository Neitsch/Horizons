/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 21, 2015
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
  @Column
  private int courseNumber;
  @ManyToMany
  private Collection<Department> department = new HashSet<>();
  @Column(columnDefinition = "TEXT")
  private String description;
  @ManyToMany
  private Collection<Instructor> instructors = new HashSet<>();
  @Column(columnDefinition = "TEXT")
  private String prerequisites;
  @ManyToMany(mappedBy = "courses")
  private Collection<Requirement> requirements = new HashSet<>();
  @ManyToMany
  private Collection<TimeSlot> slots = new HashSet<>();
  @ManyToOne
  private Term term;
  @Column
  private String title;
  @Column
  private int units;
  @Id
  @Column(columnDefinition = "BINARY(16)")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID uuid;
}
