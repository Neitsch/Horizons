/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.to;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import lombok.Data;

import com.horizons.entities.Requirement;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Oct 1, 2015
 */
@XmlSeeAlso({Requirement.class})
final @Data @XmlRootElement(name = "set") @XmlAccessorType(XmlAccessType.FIELD) public class SetContainer<T> {
  @XmlElement(name = "element")
  private Set<T> set = new HashSet<>();
}
