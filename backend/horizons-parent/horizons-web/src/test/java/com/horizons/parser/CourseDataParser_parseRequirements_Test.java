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
public class CourseDataParser_parseRequirements_Test {
  /**
   * @author nschuste
   * @version 1.0.0
   * @throws java.lang.Exception
   * @since Oct 7, 2015
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {}

  @Test
  public final void noMatch() {
    final List<String> simple =
        Arrays.asList(new String[] {"BM Foreign Lang GER (01cr)", "BM Humanities (01cr)",
            "Foundation/Gateway Course "});
    for (final String s : simple) {
      final Set<String> res = CourseDataParser.parseRequirements(s);
      Assert.assertEquals(0, res.size());
    }
  }

  @Test
  public final void parseSimple() {
    final List<String> simple =
        Arrays.asList(new String[] {"NS Lab Course GER (01cr)", "Nat Science Div GER (01cr)",
            "Quantitative Analy GER (01cr)", "Fine Arts Div GER (01cr)",
            "Foreign Language GER (01cr)", "Humanities Div GER (01cr)",
            "Social Science Div GER (01cr)"});
    for (final String s : simple) {
      final Set<String> res = CourseDataParser.parseRequirements(s);
      Assert.assertEquals(1, res.size());
    }
  }
}
