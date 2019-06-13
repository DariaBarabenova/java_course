package ru.pack.java_course.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main (String[] args){
    String [] langs = {"Java","C#","Python","PHP"};

    List<String> languagase = Arrays.asList("Java","C#","Python","PHP");

    for (String l : languagase){
      System.out.println("I want to learn " + l);
    }
  }
}
