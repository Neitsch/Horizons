/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.scraper;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import lombok.extern.slf4j.XSlf4j;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.horizons.Application;
import com.horizons.dao.RequirementDao;
import com.horizons.entities.Requirement;
import com.horizons.service.CourseService;
import com.horizons.service.DepartmentService;
import com.horizons.to.CourseRaw;
import com.horizons.to.SetContainer;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 27, 2015
 */
@Component
@XSlf4j
public class ClassScraper {
  private static final String BASE_URL = "https://bannerweb.lawrence.edu";

  private static final String CLASS_TIME = "Class Time";

  private static final String COURSE = "Course";

  private static final String CRN = "CRN";

  private static final Pattern DEPARTMENT_REGEX_PATTERN = Pattern
      .compile("([a-zA-Z \\-\\&]+) \\(([A-Z\\-]{3,})\\)");

  private static final String INSTRUCTOR = "Instructors";

  private static final String REGEX_ATTRIBUTES = "Attributes: ";

  private static final String REGEX_DESCRIPTION = "Catalog Description : ";

  private static final String REGEX_PREREQ = "Prerequisites/Notes: ";

  private static final String TERM = "Term";

  private static final String TITLE = "Title";
  private static final String UNITS = "Units";

  @Autowired
  private CourseService courseService;

  @Autowired
  private DepartmentService departmentService;

  @Autowired
  private RequirementDao requirementDao;

  @Scheduled(cron = "4 0 * * *")
  @Transactional
  @CacheEvict(value = "allCourses", allEntries = true)
  public void getClasses() {
    log.entry();
    try {
      this.ensureRequirementsExist();
      final Set<String> subjects = this.getSubjects();
      final Set<String> allClasses = new HashSet<>();
      for (final String subject : subjects) {
        allClasses.addAll(this.getClasses(subject));
      }
      for (final String course : allClasses) {
        final CourseRaw rawCourse = this.courseFromUrl(BASE_URL + course);
        if (rawCourse != null) {
          this.courseService.persistRawCourse(rawCourse);
        }
      }
      this.courseService.getAllCourses();
    } catch (final Exception e) {
      log.catching(e);
    }
  }

  protected CourseRaw courseFromUrl(final String url) throws IOException {
    final CourseRaw course = new CourseRaw();
    final Document doc = Jsoup.connect(url).get();
    Elements elem = doc.select(".pagebodydiv > .datadisplaytable > tbody:last-child");
    System.out.println(elem.html().split("<br>").length);
    for (final String row : elem.html().split("<br>")) {
      this.testFieldForRelevance(Jsoup.parse(row).text(), course);
    }
    elem =
        doc.select(".pagebodydiv > .datadisplaytable > tbody > tr > td > .datadisplaytable:first-of-type > tbody > tr");
    final Map<String, String> pairs = this.extractPairs(elem);
    if (pairs.get(CRN).length() <= 2) {
      return null;
    }
    course.setClassTime(pairs.get(CLASS_TIME));
    course.setCourse(pairs.get(COURSE));
    course.setCrn(pairs.get(CRN));
    course.setInstructor(pairs.get(INSTRUCTOR));
    course.setTerm(pairs.get(TERM));
    course.setTitle(pairs.get(TITLE));
    course.setUnits(pairs.get(UNITS));
    System.out.println(course);
    return course;
  }

  private void ensureRequirementsExist() {
    try {
      final SetContainer<Requirement> req =
          (SetContainer<Requirement>) JAXBContext.newInstance(SetContainer.class)
              .createUnmarshaller()
              .unmarshal(Application.class.getResourceAsStream("/requirements.xml"));
      for (final Requirement re : req.getSet()) {
        final Requirement save = this.requirementDao.findByShort(re.getRequirement());
        if (save == null) {
          this.requirementDao.create(re);
        }
      }
    } catch (final JAXBException e) {
      log.catching(e);
    }
  }

  /**
   * @author nschuste
   * @version 1.0.0
   * @param elem
   * @return
   * @since Sep 27, 2015
   */
  private Map<String, String> extractPairs(final Elements elem) {
    final Iterator<Element> e = elem.iterator();
    final Map<String, String> result = new HashMap<>();
    while (e.hasNext()) {
      final Element row = e.next();
      final Elements nodes = row.children();
      if (nodes.size() > 0) {
        result.put(nodes.get(0).text().trim(), nodes.get(1).text());
        if (nodes.size() > 2) {
          result.put(nodes.get(2).text().trim(), nodes.get(3).text());
        }
      }
    }
    return result;
  }

  /**
   * @author nschuste
   * @version 1.0.0
   * @param string
   * @return
   * @throws IOException
   * @since Sep 27, 2015
   */
  private Set<String> getClasses(final String string) throws IOException {
    log.entry(string);
    final Set<String> classes = new HashSet<>();
    final Document doc = Jsoup.connect(string).timeout(10000).get();
    final Elements elem =
        doc.select(".pagebodydiv > .datadisplaytable > tbody > tr > td.dddefault > a[href]");
    final Iterator<Element> iter = elem.iterator();
    while (iter.hasNext()) {
      final Element element = iter.next();
      classes.add(element.attr("href"));
    }
    return log.exit(classes);
  }

  private Set<String> getSubjects() throws IOException {
    log.entry();
    final Set<String> subjects = new HashSet<>();
    final Document doc =
        Jsoup.connect("https://www.lawrence.edu/s/registrar/catalog/cs-current").get();
    final Elements elem = doc.select("#node-7150 li");
    final Iterator<Element> iter = elem.iterator();
    while (iter.hasNext()) {
      final Element element = iter.next();
      this.ensureDepartmentExists(element.text());
      subjects.add(element.select("a[href]").attr("href"));
    }
    return log.exit(subjects);
  }

  private void testFieldForRelevance(final String raw, final CourseRaw course) {
    if (raw.matches("^" + REGEX_PREREQ + ".*")) {
      course.setPrerequisites(raw.substring(REGEX_PREREQ.length()));
    } else if (raw.matches("^" + REGEX_DESCRIPTION + ".*")) {
      course.setDescription(raw.substring(REGEX_DESCRIPTION.length()));
    } else if (raw.matches("^" + REGEX_ATTRIBUTES + ".*")) {
      course.setAttributes(raw.substring(REGEX_ATTRIBUTES.length()));
    }
  }

  /**
   * @author nschuste
   * @version 1.0.0
   * @param text
   * @since Sep 28, 2015
   */
  void ensureDepartmentExists(final String text) {
    final Matcher m = DEPARTMENT_REGEX_PATTERN.matcher(text);
    while (m.find()) {
      this.departmentService.ensureDepartmentExists(m.group(1), m.group(2));
    }
  }
}
