/**
 * Copyright 2015 Nigel Schuster.
 */


package com.schuster.web;

import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.schuster.entities.TimeSlot;
import com.schuster.service.TimeSlotService;

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
    slot.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(Dummy.class).test())
        .withSelfRel());
    return "ok";
  }
}
