/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.to;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Oct 7, 2015
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRaw {
  private String data;
}
