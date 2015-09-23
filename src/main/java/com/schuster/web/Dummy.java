/**
 * Copyright 2015 Nigel Schuster.
 */


package com.schuster.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.schuster.service.InstructorService;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 23, 2015
 */
@RestController
@RequestMapping("/instructor")
public class Dummy {
  @Autowired
  private InstructorService service;

  @RequestMapping(value = "/test", method = RequestMethod.GET)
  public String test() {
    return "ok";
  }
}
