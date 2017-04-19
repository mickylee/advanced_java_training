package com.ppdai.jt.homework1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ppdai.jt.homework1.Homework;

public class HomeworkTest {

  @Test
  public void testReverse() {
    Homework homework = new Homework();
    assertEquals("Input", homework.reverse("tupnI"));
  }

  @Test
  public void testGetCommonSuffix() {
    Homework homework = new Homework();
    assertEquals("JavaFundamentals", homework.getCommonSuffix("AmazingJavaFundamentals", "ILoveJavaFundamentals"));
  }
}
