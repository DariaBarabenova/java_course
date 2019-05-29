
package ru.pack.java_course.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
      hello ("world");
      hello("user");
      hello("Daria");


      Square s = new Square(5);
      System.out.println("Square of a square with side " + s.l + "= " + s.area());

      Rectangle r = new Rectangle(4, 6);
      System.out.println("Square of a rectangle with sides " +r.a+ " and" +r.b+ " = " + r.area());
      System.out.println(Math.sqrt(16));


      Point p1 = new Point(2,3);
      p1.x = 2;
      p1.y = 3;

      Point p2 = new Point(5,7);
      p2.x = 5;
      p2.y = 7;


      distance(p1,p2);

    System.out.println("Distance from Object: "+ p1.pointDistance(p2));



    }


  public static void distance(Point p1, Point p2){
    System.out.println("Distance = " + point (p1, p2));
  }



  public static void hello (String somebody) {

    System.out.println("Hello " + somebody + "!");

  }

  public static double area (Rectangle r) {
    return r.a*r.b;
  }



  public static double point(Point p1, Point p2){
    return (Math.sqrt(Math.pow((p2.x - p1.x) , 2)+Math.pow((p2.y-p1.y), 2)));
  }


  }




