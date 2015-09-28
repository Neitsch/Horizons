/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.web;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 23, 2015
 */
@RestController
@RequestMapping("/public")
public class Dummy {
  @ResponseStatus(value = HttpStatus.OK)
  @RequestMapping(value = "/alive", method = RequestMethod.GET)
  @PreAuthorize("permitAll")
  public void test() {

  }

  @ResponseStatus(value = HttpStatus.OK)
  @RequestMapping(value = "/logged", method = RequestMethod.GET)
  @PreAuthorize("denyAll")
  public void test2() {

  }
}
