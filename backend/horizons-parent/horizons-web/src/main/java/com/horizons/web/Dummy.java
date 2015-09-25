/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.horizons.service.TimeSlotService;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 23, 2015
 */
@RestController
public class Dummy {
  @Autowired
  private TimeSlotService service;

  @ResponseStatus(value = HttpStatus.OK)
  @RequestMapping(value = "/alive", method = RequestMethod.GET)
  public void test() {

  }
}
