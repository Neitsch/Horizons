/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.scraper;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.horizons.to.CourseRaw;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 27, 2015
 */
public class ClassScraping_Test {
  private static ClassScraper scraper;

  @BeforeClass
  public static void setup() {
    System.setProperty("https.protocols", "SSLv3,SSLv2Hello,TLSv1");
    scraper = new ClassScraper();
  }

  @Test
  public void simple() throws IOException {
    final CourseRaw course =
        scraper
            .courseFromUrl("https://bannerweb.lawrence.edu/pls/voyager/bwckschd.p_lu_call_unsec?last_term_in=201550&term_in=201550&ptrm_in=1&crn_in=5052&subj_code_in=ANTH&crse_numb_in=200&seq_numb_in=0&regstart_fdate_in=&regstart_tdate_in=");
  }

  @Test
  public void test() {
    scraper.ensureDepartmentExists("East Asian Studies Program (EAST)");
  }
}
