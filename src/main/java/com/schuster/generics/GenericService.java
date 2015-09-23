/**
 * Copyright 2015 Nigel Schuster.
 */


package com.schuster.generics;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 9, 2015
 */
@Service
public interface GenericService<E> {
  public UUID create(E entity);

  public void createOrUpdate(E entity);

  public void delete(E entity);

  public List<E> getAll();

  public E read(UUID key);

  public void update(E entity);
}
