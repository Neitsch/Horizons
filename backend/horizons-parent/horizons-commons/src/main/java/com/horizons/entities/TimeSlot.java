/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.entities;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.LocalTime;

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
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"weekDay", "start", "end"})})
public class TimeSlot implements Serializable {
  @Column(nullable = false)
  @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalTimeAsTime")
  @JsonView(AllCoursesView.class)
  private LocalTime end;
  @ManyToMany(mappedBy = "slots")
  private Collection<Course> instances = new HashSet<>();
  @Column(nullable = false)
  @JsonView(AllCoursesView.class)
  @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalTimeAsTime")
  private LocalTime start;
  @Id
  @Column(columnDefinition = "BINARY(16)")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID uuid;
  @Column(nullable = false)
  @JsonView(AllCoursesView.class)
  private DayOfWeek weekDay;
}
