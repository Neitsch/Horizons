/**
 * Copyright 2015 Nigel Schuster.
 */


package com.schuster.generics;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 9, 2015
 */
@Repository
public interface GenericDao<E, PK extends Serializable> {
  /**
   * Creates the given entity in the underlying persistence unit.
   * 
   * @author nschuste
   * @version 1.0.0
   * @param entity
   * @return
   * @since Sep 10, 2015
   */
  public PK create(E entity);

  public void createOrUpdate(E entity);

  public void delete(E entity);

  public List<E> getAll();

  public E read(PK key);

  public void update(E entity);
}
