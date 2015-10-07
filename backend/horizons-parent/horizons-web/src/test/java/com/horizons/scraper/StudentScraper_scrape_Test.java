/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.scraper;

import java.io.IOException;

import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.junit.BeforeClass;
import org.junit.Test;

import com.horizons.to.UserTO;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Oct 7, 2015
 */
public class StudentScraper_scrape_Test {
  private static StudentScraperImpl scraper;

  /**
   * @author nschuste
   * @version 1.0.0
   * @throws java.lang.Exception
   * @since Oct 7, 2015
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    System.setProperty("https.protocols", "SSLv3,SSLv2Hello,TLSv1");
    scraper = new StudentScraperImpl();
  }

  @Test
  public final void test() throws IOException {
    final String session =
        Jsoup.connect("https://bannerweb.lawrence.edu/pls/voyager/twbkwbis.P_ValLogin")
            .data("sid", "schusten", "PIN", "").cookie("TESTID", "SET").method(Method.POST)
            .execute().cookie(UserTO.SessionIdentifier);
    scraper.scrapeInt(session);
  }
}
