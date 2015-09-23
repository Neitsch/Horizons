/**
 * Copyright 2015 Nigel Schuster.
 */


package com.schuster.dao.impl;

import org.springframework.stereotype.Repository;

import com.schuster.dao.DepartmentDao;
import com.schuster.entities.Department;
import com.schuster.generics.GenericDaoImpl;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 22, 2015
 */
@Repository
public class DepartmentDaoImpl extends GenericDaoImpl<Department> implements DepartmentDao {
}
