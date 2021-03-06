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

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonView;
import com.horizons.jsonview.AllCoursesView;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 21, 2015
 */
@Data
@Entity
public class Requirement implements Serializable {
  public enum RequirementEnum {
    DIV_ARTS, DIV_DIVERSITY, DIV_GLOBAL, DIV_HUMANITIES, DIV_QUANT, DIV_S, DIV_SCIENCE, DIV_SOCIAL,
    DIV_W, NS_LAB
  }

  @Column(unique = true)
  private String classViewRepresentation;
  @ManyToMany
  private Collection<Course> courses = new HashSet<>();
  @Column(unique = true)
  @JsonView(AllCoursesView.class)
  private String name;
  @Column(unique = true)
  private RequirementEnum requirement;
  @Id
  @Column(columnDefinition = "BINARY(16)")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID uuid;
}
