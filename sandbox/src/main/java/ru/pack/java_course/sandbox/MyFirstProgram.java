
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


    double c = 2;
    double d = 3;
    double e = 5;
    double f = 7;
    double t = coordinates2(f,d);
    double v = coordinates1(c,e);



    System.out.println("Point1 coodinates = " + c +"," + d + " , Point2 coodinates = " + e +"," + f );
    System.out.println("Differense1 = " + t + "and" + "Differense2 = " + v);
    System.out.println("Distance = " + distance(t,v));


        }



  public static void hello (String somebody) {

    System.out.println("Hello " + somebody + "!");

  }

  public static double area (Rectangle r) {
    return r.a*r.b;
  }


  public static double coordinates1 (double c, double e){
    return(e-c);
  }

  public static double coordinates2 (double f, double d){
    return(f-d);
  }

  public static double distance (double t, double v){
    return (Math.sqrt(Math.pow(t, 2)+Math.pow(v, 2)));
  }
  }




