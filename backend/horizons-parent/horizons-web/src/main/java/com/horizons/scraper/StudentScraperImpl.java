/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.scraper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.extern.slf4j.XSlf4j;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.security.core.context.SecurityContextHolder;

import com.horizons.to.StudentRaw;
import com.horizons.to.UserTO;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Oct 7, 2015
 */
@XSlf4j
public class StudentScraperImpl implements StudentScraper {
  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.horizons.scraper.StudentScraper#scrape(java.lang.String)
   * @since Oct 7, 2015
   */
  @Override
  public StudentRaw scrape(final String name) {
    try {
      return this.scrapeInt((String) SecurityContextHolder.getContext().getAuthentication()
          .getCredentials());
    } catch (final IOException e) {
      log.catching(e);
    }
    return null;
  }

  protected StudentRaw scrapeInt(final String session) throws IOException {
    final Document doc =
        Jsoup.connect("https://bannerweb.lawrence.edu/pls/voyager/zwlkflis.P_StuDisplaySchd")
            .cookie(UserTO.SessionIdentifier, session).get();
    final Elements elem = doc.select(".pagebodydiv > .datadisplaytable > tbody > tr");
    final Iterator<Element> it = elem.iterator();
    String term = "";
    while (it.hasNext()) {
      final Element element = it.next();
      if (element.text().length() <= 0) {
        continue;
      }
      if (!Character.isDigit(element.text().charAt(0))) {
        term = element.text().trim();
        continue;
      }
      final List<String> res = new ArrayList<>();
      final Iterator<Element> iterator = element.select("td").iterator();
      while (iterator.hasNext()) {
        res.add(iterator.next().text());

      }
      log.info(res.toString());
    }
    return null;
  }
}
