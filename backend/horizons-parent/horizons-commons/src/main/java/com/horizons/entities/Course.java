/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.entities;

import java.io.Serializable;
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
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonView;
import com.horizons.jsonview.AllCoursesView;

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
public class Course implements Serializable {
  @Column
  @JsonView(AllCoursesView.class)
  private int courseNumber;
  @Column()
  @JsonView(AllCoursesView.class)
  private int crn;
  @ManyToMany()
  @JsonView(AllCoursesView.class)
  @LazyCollection(LazyCollectionOption.FALSE)
  private Collection<Department> department = new HashSet<>();
  @Column(columnDefinition = "TEXT")
  @JsonView(AllCoursesView.class)
  private String description;
  @ManyToMany()
  @JsonView(AllCoursesView.class)
  @LazyCollection(LazyCollectionOption.FALSE)
  private Collection<Instructor> instructors = new HashSet<>();
  @Column(columnDefinition = "TEXT")
  @JsonView(AllCoursesView.class)
  private String prerequisites;
  @ManyToMany(mappedBy = "courses")
  @JsonView(AllCoursesView.class)
  @LazyCollection(LazyCollectionOption.FALSE)
  private Collection<Requirement> requirements = new HashSet<>();
  @ManyToMany()
  @LazyCollection(LazyCollectionOption.FALSE)
  @JsonView(AllCoursesView.class)
  private Collection<TimeSlot> slots = new HashSet<>();
  @ManyToOne
  @JsonView(AllCoursesView.class)
  private Term term;
  @Column
  @JsonView(AllCoursesView.class)
  private String title;
  @Column
  @JsonView(AllCoursesView.class)
  private int units;
  @Id
  @Column(columnDefinition = "BINARY(16)")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @JsonView(AllCoursesView.class)
  private UUID uuid;
}
