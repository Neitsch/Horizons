/**
 * Copyright 2015 Nigel Schuster.
 */


package com.schuster.generics;

import java.util.List;
import java.util.UUID;

import lombok.extern.slf4j.XSlf4j;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 9, 2015
 */
@XSlf4j
public class GenericServiceImpl<E> implements GenericService<E> {

  private final GenericDao<E> genericDao;

  public GenericServiceImpl(final GenericDao<E> genericDao) {
    log.entry(genericDao);
    this.genericDao = genericDao;
    log.exit();
  }

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.schuster.service.GenericService#create(java.lang.Object)
   * @since Sep 9, 2015
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public UUID create(final E entity) {
    log.entry(entity);
    return log.exit(this.genericDao.create(entity));
  }

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.schuster.service.GenericService#createOrUpdate(java.lang.Object)
   * @since Sep 9, 2015
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public void createOrUpdate(final E entity) {
    log.entry(entity);
    this.genericDao.createOrUpdate(entity);
    log.exit();
  }

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.schuster.service.GenericService#delete(java.lang.Object)
   * @since Sep 9, 2015
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public void delete(final E entity) {
    log.entry(entity);
    this.genericDao.delete(entity);
    log.exit();
  }

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.schuster.service.GenericService#getAll()
   * @since Sep 9, 2015
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
  public List<E> getAll() {
    log.entry();
    return log.exit(this.genericDao.getAll());
  }

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.schuster.service.GenericService#read(java.io.Serializable)
   * @since Sep 9, 2015
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
  public E read(final UUID key) {
    log.entry(key);
    return log.exit(this.genericDao.read(key));
  }

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.schuster.service.GenericService#update(java.lang.Object)
   * @since Sep 9, 2015
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public void update(final E entity) {
    log.entry(entity);
    this.genericDao.update(entity);
    log.exit();
  }
}
