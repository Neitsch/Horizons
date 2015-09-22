/**
 * Copyright 2015 Nigel Schuster.
 */


package com.schuster;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 21, 2015
 */
public class Main_Test {
  public static void main(final String[] args) {
    final SessionFactory factory = new Configuration().configure().buildSessionFactory();
  }
}
