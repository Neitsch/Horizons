/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.web;

import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.horizons.entities.TimeSlot;
import com.horizons.service.TimeSlotService;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 23, 2015
 */
@RestController
@RequestMapping("/instructor")
public class Dummy {
  @Autowired
  private TimeSlotService service;

  @RequestMapping(value = "/test", method = RequestMethod.GET)
  public String test() {
    final TimeSlot slot = new TimeSlot();
    slot.setStart(new LocalTime(19, 00));
    return "ok";
  }
}
