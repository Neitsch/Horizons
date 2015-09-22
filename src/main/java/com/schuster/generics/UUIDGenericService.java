/**
 * Copyright 2015 Nigel Schuster.
 */


package com.schuster.generics;

import java.util.UUID;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
public class UUIDGenericService<E> extends GenericServiceImpl<E, UUID> {

  /**
   * @author nschuste
   * @version 1.0.0
   * @param genericDao
   * @since Sep 22, 2015
   */
  public UUIDGenericService(final GenericDao<E, UUID> genericDao) {
    super(genericDao);
  }
}
