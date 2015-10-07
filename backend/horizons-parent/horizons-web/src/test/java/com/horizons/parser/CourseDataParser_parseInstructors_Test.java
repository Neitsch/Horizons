/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.parser;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Oct 7, 2015
 */
public class CourseDataParser_parseInstructors_Test {
  private static CourseDataParser parser;

  @BeforeClass
  public static void beforeClass() {
    parser = new CourseDataParser();
  }

  @Test
  public void testSingle() {
    final List<String> tests =
        Arrays.asList(new String[] {"Nigel Schuster", " Nigel Schuster", "Nigel Schuster ",
            "Nigel S. Schuster", "Ann Kohlbeck Boeckman", " Donna Jeanne DiBella",
            "John H. Benson", "I Dewa K.A. Adnyana", "Mary F. Van De Loo",});
    for (final String string : tests) {
      final Set<String> res = CourseDataParser.parseInstructors(string);
      Assert.assertEquals(1, res.size());
      Assert.assertEquals(string.trim(), res.iterator().next());
    }
  }

  @Test
  public void testTwo() {
    final String inst = "Jay R. Stork, Allison M. M. Fleshman";
    final Set<String> res = CourseDataParser.parseInstructors(inst);
    Assert.assertEquals(2, res.size());
    Assert.assertTrue(res.contains("Jay R. Stork"));
    Assert.assertTrue(res.contains("Allison M. M. Fleshman"));
  }
}
