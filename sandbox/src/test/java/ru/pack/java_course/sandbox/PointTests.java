package ru.pack.java_course.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
  @Test
  public void testDistance () {
    Point p1 = new Point (2,3);
    Point p2 = new Point(5,7);
    Assert.assertEquals(p1.pointDistance(p2),5);
  }
}
