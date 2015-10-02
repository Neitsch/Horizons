/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.serialization;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.datatype.joda.JodaModule;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Oct 2, 2015
 */
@Component
public class JacksonConfig extends JodaModule {
  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.fasterxml.jackson.databind.module.SimpleModule#setupModule(com.fasterxml.jackson.databind.Module.SetupContext)
   * @since Oct 2, 2015
   */
  // @Override
  // public void setupModule(final SetupContext arg0) {
  // super.setupModule(arg0);
  // this.addSerializer(new JodaTimeSerializer());
  // }
}
