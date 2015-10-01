/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 30, 2015
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Triple<A, B, C> {
  private A a;
  private B b;
  private C c;
}
