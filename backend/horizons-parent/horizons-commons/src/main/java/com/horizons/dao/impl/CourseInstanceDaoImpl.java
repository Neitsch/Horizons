/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.dao.impl;

import org.springframework.stereotype.Repository;

import com.horizons.dao.CourseInstanceDao;
import com.horizons.entities.CourseInstance;
import com.horizons.generics.GenericDaoImpl;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
@Repository
public class CourseInstanceDaoImpl extends GenericDaoImpl<CourseInstance> implements
    CourseInstanceDao {
}
