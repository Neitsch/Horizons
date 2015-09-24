/**
 * Copyright 2015 Nigel Schuster.
 */


package com.schuster.entities;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.LocalTime;
import org.springframework.hateoas.ResourceSupport;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 21, 2015
 */
@Data
@Entity
public class TimeSlot extends ResourceSupport {
  @Column
  @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalTimeAsTime")
  private LocalTime end;
  @ManyToMany(mappedBy = "slots")
  private Set<CourseInstance> instances = new HashSet<>();
  @Column
  @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalTimeAsTime")
  private LocalTime start;
  @Id
  @Column(columnDefinition = "BINARY(16)")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID uuid;
  @Column
  private DayOfWeek weekDay;
}
