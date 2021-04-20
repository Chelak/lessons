package com.celac.anotation.app.services;

import org.junit.Test;

public class ChallengeTests {

  @Test
  public void stringBufferChallenge() {
    Object obj = null;
    StringBuffer buffer = new StringBuffer(10);
    buffer.append("noBugs ");
    buffer.append("project ");
    buffer.append(obj);
    buffer.insert(14, '!');
    System.out.println(buffer);
  }

  @Test
  public void timeTest(){
      long t1 = System.nanoTime();
      long t3 = System.currentTimeMillis();
      long t2 = System.nanoTime();
    System.out.println("t1: " + t2);
    System.out.println("t2: " + t2);
    System.out.println("t3: " + t3);

    System.out.println(t2 < t1);
    System.out.println(t3 < 0);
    System.out.println(t1 < 0);

  }



}
