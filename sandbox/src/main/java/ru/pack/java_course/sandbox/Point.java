package ru.pack.java_course.sandbox;

public class Point {

  public double x;
  public double y;

  public Point (double p1, double p2){
    p1 = p1;
    p2 = p2;
  }

  public double pointDistance(Point p){
    return (Math.sqrt(Math.pow((p.x - this.x) , 2)+Math.pow((p.y-this.y), 2)));

  }



}
