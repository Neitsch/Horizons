/**
 * Copyright 2015 Nigel Schuster.
 */


package com.schuster.service.impl;

import lombok.extern.slf4j.XSlf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schuster.dao.TermDao;
import com.schuster.service.TermService;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 23, 2015
 */
@Service
@XSlf4j
public class TermServiceImpl implements TermService {
  @Autowired
  private TermDao dao;
}
