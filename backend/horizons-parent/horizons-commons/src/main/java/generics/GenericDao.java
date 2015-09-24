/**
 * Copyright 2015 Nigel Schuster.
 */


package com.schuster.generics;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 9, 2015
 */
@Repository
public interface GenericDao<E> {
  /**
   * Creates the given entity in the underlying persistence unit.
   *
   * @author nschuste
   * @version 1.0.0
   * @param entity
   * @return
   * @since Sep 10, 2015
   */
  public UUID create(E entity);

  public void createOrUpdate(E entity);

  public void delete(E entity);

  public List<E> getAll();

  public E read(UUID key);

  public void update(E entity);
}
