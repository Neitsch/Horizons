/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 30, 2015
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pair<K, V> {
  private K key;
  private V value;
}
