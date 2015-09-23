/**
 * Copyright 2015 Nigel Schuster.
 */


package com.schuster.service.impl;

import lombok.extern.slf4j.XSlf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schuster.dao.ScheduleDao;
import com.schuster.service.ScheduleService;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 23, 2015
 */
@Service
@XSlf4j
public class ScheduleServiceImpl implements ScheduleService {
  @Autowired
  private ScheduleDao dao;
}
