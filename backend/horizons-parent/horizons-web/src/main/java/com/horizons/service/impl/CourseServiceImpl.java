/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import lombok.extern.slf4j.XSlf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horizons.dao.CourseDao;
import com.horizons.dao.DepartmentDao;
import com.horizons.dao.InstructorDao;
import com.horizons.dao.RequirementDao;
import com.horizons.dao.TimeSlotDao;
import com.horizons.entities.Course;
import com.horizons.entities.Department;
import com.horizons.entities.Instructor;
import com.horizons.entities.Requirement;
import com.horizons.entities.TimeSlot;
import com.horizons.parser.CourseDataParser;
import com.horizons.service.CourseService;
import com.horizons.to.CalendarItem;
import com.horizons.to.CourseRaw;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 23, 2015
 */
@Service
@XSlf4j
public class CourseServiceImpl implements CourseService {
  @Autowired
  private CourseDao dao;
  @Autowired
  private DepartmentDao departmentDao;
  @Autowired
  private InstructorDao instructorDao;
  @Autowired
  private RequirementDao requirementDao;
  @Autowired
  private TimeSlotDao timeSlotDao;

  /**
   * {@inheritDoc}
   *
   * @author nschuste
   * @version 1.0.0
   * @see com.horizons.service.CourseInstanceService#persistRawCourse(com.horizons.to.CourseRaw)
   * @since Sep 28, 2015
   */
  @Override
  public void persistRawCourse(final CourseRaw rawCourse) {
    log.entry(rawCourse);
    final String departmentName = rawCourse.getCourse().split(" ")[0];
    final Department department = this.departmentDao.findByShortName(departmentName);
    final Course course = new Course();
    course.setDepartment(Arrays.asList(department));
    course.setSlots(this.findSlots(CourseDataParser.parseTime(rawCourse.getClassTime())));
    course.setInstructors(this.findInstructors(CourseDataParser.parseInstructors(rawCourse
        .getInstructor())));
    course.setRequirements(this.findRequirements(CourseDataParser.parseRequirements(rawCourse
        .getAttributes())));
    log.exit();
  }

  /**
   * @author nschuste
   * @version 1.0.0
   * @param parseInstructors
   * @return
   * @since Oct 1, 2015
   */
  private Collection<Instructor> findInstructors(final Set<String> parseInstructors) {
    final Set<Instructor> instructors = new HashSet<>();
    for (final String instructor : parseInstructors) {
      Instructor in = this.instructorDao.findByName(instructor);
      if (in == null) {
        final UUID id = this.instructorDao.create(Instructor.builder().name(instructor).build());
        in = this.instructorDao.read(id);
      }
      instructors.add(in);
    }
    return instructors;
  }

  /**
   * @author nschuste
   * @version 1.0.0
   * @param parseRequirements
   * @return
   * @since Oct 1, 2015
   */
  private Collection<Requirement> findRequirements(final Set<String> parseRequirements) {
    final Set<Requirement> req = new HashSet<>();
    for (final String requirement : parseRequirements) {
      final Requirement r = this.requirementDao.findByClassSpec(requirement.trim());
      if (r == null) {
        log.info(requirement);
      } else {
        log.info("Found");
        req.add(r);
      }
    }
    return req;
  }

  /**
   * @author nschuste
   * @version 1.0.0
   * @param parseTime
   * @return
   * @since Oct 1, 2015
   */
  private Collection<TimeSlot> findSlots(final Set<CalendarItem> parseTime) {
    final Set<TimeSlot> slots = new HashSet<>();
    for (final CalendarItem calendarItem : parseTime) {
      TimeSlot slot =
          this.timeSlotDao.findByDayAndTime(calendarItem.getDay(), calendarItem.getStart(),
              calendarItem.getEnd());
      if (slot == null) {
        slot =
            TimeSlot.builder().weekDay(calendarItem.getDay()).start(calendarItem.getStart())
                .end(calendarItem.getEnd()).build();
        final UUID id = this.timeSlotDao.create(slot);
        slot = this.timeSlotDao.read(id);
      }
      slots.add(slot);
    }
    return slots;
  }
}
