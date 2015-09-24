/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.dao.impl;

import org.springframework.stereotype.Repository;

import com.horizons.dao.RequirementDao;
import com.horizons.entities.Requirement;
import com.horizons.generics.GenericDaoImpl;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
@Repository
public class RequirementDaoImpl extends GenericDaoImpl<Requirement> implements RequirementDao {
}
