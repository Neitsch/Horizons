/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.scraper;

import com.horizons.to.StudentRaw;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Oct 7, 2015
 */
public interface StudentScraper {
  public StudentRaw scrape(String name);
}
