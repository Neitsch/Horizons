/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons;

import lombok.extern.slf4j.XSlf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 23, 2015
 */
@XSlf4j
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class})
@ComponentScan
// @EnableTransactionManagement
@ImportResource("classpath:spring.xml")
public class Application {
  /**
   * @author nschuste
   * @version 1.0.0
   * @since Sep 24, 2015
   */
  private Application() {}

  public static void main(final String[] args) {
    log.entry(args);
    SpringApplication.run(Application.class, args);
    log.exit();
  }
}
