/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 21, 2015
 */
@Entity
@Data
public class User implements Serializable {
  @ManyToMany
  private Set<Course> courses;
  @Column
  private Date enrollmentDate;
  @Column(unique = true)
  private String externalId;
  @Column
  private String firstName;
  @Column
  private String lastName;
  @ManyToMany
  private Collection<Schedule> schedules = new HashSet<>();
  @Column(unique = true)
  private String username;
  @Id
  @Column(columnDefinition = "BINARY(16)")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID uuid;
}
