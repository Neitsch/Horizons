/**
 * Copyright 2015 Nigel Schuster.
 */


package com.schuster.dao.impl;

import org.springframework.stereotype.Repository;

import com.schuster.dao.RequirementDao;
import com.schuster.entities.Requirement;
import com.schuster.generics.GenericDaoImpl;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
@Repository
public class RequirementDaoImpl extends GenericDaoImpl<Requirement> implements RequirementDao {
}
