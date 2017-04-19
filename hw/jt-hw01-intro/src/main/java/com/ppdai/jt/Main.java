package com.ppdai.jt;

import com.ppdai.jt.homework1.Homework;

public class Main {
  public static void main(String[] args) {
    if (args.length < 2) {
      System.err.println("Usage: java -jar target/jt-homework1.jar firstString secondString");
      System.exit(0);
    }
    Homework homework = new Homework();
    System.out.println(homework.getCommonSuffix(args[0], args[1]));
  }
}
