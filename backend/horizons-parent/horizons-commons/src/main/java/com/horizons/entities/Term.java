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
import javax.persistence.OneToMany;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonView;
import com.horizons.jsonview.AllCoursesView;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 21, 2015
 */
@Entity
@Data
public class Term {
  @Column
  @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDate")
  @JsonView(AllCoursesView.class)
  private LocalDate end;
  @OneToMany(mappedBy = "term")
  private Collection<Course> instances = new HashSet<>();
  @Column
  @JsonView(AllCoursesView.class)
  private String name;
  @Column
  @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDate")
  @JsonView(AllCoursesView.class)
  private LocalDate start;
  @Id
  @Column(columnDefinition = "BINARY(16)")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID uuid;
}
