/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.generics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

import lombok.extern.slf4j.XSlf4j;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 9, 2015
 */
@XSlf4j
public abstract class GenericDaoImpl<E> implements GenericDao<E> {
  protected Class<? extends E> daoType;
  @Autowired
  private final SessionFactory sessionFactory = null;

  /**
   * @author nschuste
   * @version 1.0.0
   * @since Sep 9, 2015
   */
  public GenericDaoImpl() {
    log.entry();
    final Type t = this.getClass().getGenericSuperclass();
    final ParameterizedType pt = (ParameterizedType) t;
    this.daoType = (Class) pt.getActualTypeArguments()[0];
    log.debug("Got daoType: " + this.daoType.getName());
    log.exit();
  }

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.schuster.dao.GenericDao#create(java.lang.Object)
   * @since Sep 9, 2015
   */
  @Override
  public UUID create(final E entity) {
    log.entry(entity);
    final UUID key = (UUID) this.currentSession().save(entity);
    return log.exit(key);
  }

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.schuster.dao.GenericDao#createOrUpdate(java.lang.Object)
   * @since Sep 9, 2015
   */
  @Override
  public void createOrUpdate(final E entity) {
    log.entry(entity);
    this.currentSession().saveOrUpdate(entity);
    log.exit();
  }

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.schuster.dao.GenericDao#delete(java.lang.Object)
   * @since Sep 9, 2015
   */
  @Override
  public void delete(final E entity) {
    log.entry(entity);
    this.currentSession().delete(entity);
    log.exit();
  }

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.schuster.dao.GenericDao#getAll()
   * @since Sep 9, 2015
   */
  @Override
  public List<E> getAll() {
    log.entry();
    return log.exit(this.currentSession().createCriteria(this.daoType).list());
  }

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.schuster.dao.GenericDao#read(java.io.Serializable)
   * @since Sep 9, 2015
   */
  @Override
  public E read(final UUID key) {
    log.entry(key);
    return log.exit((E) this.currentSession().get(this.daoType, key));
  }

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.schuster.dao.GenericDao#update(java.lang.Object)
   * @since Sep 9, 2015
   */
  @Override
  public void update(final E entity) {
    log.entry(entity);
    this.currentSession().update(entity);
    log.exit();
  }

  protected Session currentSession() {
    return this.sessionFactory.getCurrentSession();
  }
}
