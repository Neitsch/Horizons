/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.serialization;

import java.io.IOException;

import org.joda.time.LocalTime;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Oct 2, 2015
 */
public class JodaTimeSerializer extends JsonSerializer<LocalTime> {
  /**
   * {@inheritDoc}
   * 
   * @author nschuste
   * @version 1.0.0
   * @see com.fasterxml.jackson.databind.JsonSerializer#handledType()
   * @since Oct 2, 2015
   */
  @Override
  public Class<LocalTime> handledType() {
    return LocalTime.class;
  }

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.fasterxml.jackson.databind.ser.std.StdSerializer#serialize(java.lang.Object,
   *      com.fasterxml.jackson.core.JsonGenerator,
   *      com.fasterxml.jackson.databind.SerializerProvider)
   * @since Oct 2, 2015
   */
  @Override
  public void serialize(final LocalTime arg0, final JsonGenerator arg1,
      final SerializerProvider arg2) throws IOException, JsonGenerationException {
    arg1.writeString(arg0.toString());
  }
}
