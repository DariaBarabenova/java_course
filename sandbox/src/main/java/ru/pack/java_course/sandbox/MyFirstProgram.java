
package ru.pack.java_course.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello ("world");
    hello("user");
    hello("Daria");

    double l = 5;
    System.out.println("Square squar with side " + l + "= " + area(l));

    double a = 4;
    double b = 6;
    System.out.println("Square af a rectangle with sides " +a+ "and" +b+ "= " + area(a, b));

  }
   public static void hello (String somebody) {

            System.out.println("Hello " + somebody + "!");

  }
  public static double area (double len) {
    return len*len;
  }
  public static double area (double a, double b) {
    return a*b;
  }

}