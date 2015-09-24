/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.service.impl;

import lombok.extern.slf4j.XSlf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horizons.dao.CourseDao;
import com.horizons.service.CourseService;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 23, 2015
 */
@Service
@XSlf4j
public class CourseServiceImpl implements CourseService {
  @Autowired
  private CourseDao dao;
}
