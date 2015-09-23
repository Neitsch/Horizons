/**
 * Copyright 2015 Nigel Schuster.
 */


package com.schuster;

import lombok.extern.slf4j.XSlf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 23, 2015
 */
@XSlf4j
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class})
@ComponentScan
@EnableTransactionManagement
@ImportResource("classpath:spring.xml")
public class Application {
  public static void main(final String[] args) {
    log.entry(args);
    SpringApplication.run(Application.class, args);
    log.exit();
  }
}
