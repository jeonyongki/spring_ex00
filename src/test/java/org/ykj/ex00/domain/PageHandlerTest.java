package org.ykj.ex00.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageHandlerTest {

  @Test
  public void calculatorTest(){
    //소수점 올림
    double v3 = Math.ceil(5.1);
    double v4 = Math.ceil(-5.9);
    System.out.println("v3 : "+v3);//6.0
    System.out.println("v4 : "+v4);//-5.0
    int begin = ((25-1) / 10)*10 +1;
    System.out.println("begin = " + begin);
    //최소값
    int v9 = Math.min(5, 9);
    double v10 = Math.min(5.3, 2.5);
    System.out.println("v9 : "+v9);
    System.out.println("v10 : "+v10);
    System.out.println("---------------------------------");
    //total 페이지 계산
    int totalPage = (int)Math.ceil((double) 255 / 10);
    System.out.println(255/10);
    System.out.println((double) 255/10);
    System.out.println("totalPage = " + totalPage);
    System.out.println("---------------------------------");
    int totalPage2 = (255%10 > 0) ? (255/10)+1 : 255/10;
    double rest = 255%10;
    boolean rs = (255%10 > 0);
    System.out.println("rest = " + rest);
    System.out.println("result = " + rs);
    System.out.println("totalPage2 = " + totalPage2);
  }
  //검증
  @Test
  public void test(){
    PageHandler ph = new PageHandler(250,1);
    ph.print();
    System.out.println("ph = " + ph);
    assertTrue(ph.getBeginPage()==1);
    assertTrue(ph.getEndPage()==10);
  }
  @Test
  public void test2(){
    PageHandler ph = new PageHandler(250,15);
    ph.print();
    System.out.println("ph = " + ph);
    assertTrue(ph.getBeginPage()==11);
    assertTrue(ph.getEndPage()==20);
  }
  @Test
  public void test3(){
    PageHandler ph = new PageHandler(255,25);
    ph.print();
    System.out.println("ph = " + ph);
    assertTrue(ph.getBeginPage()==21);
    assertTrue(ph.getEndPage()==26);
  }
  @Test
  public void test4(){
    PageHandler ph = new PageHandler(255,10);
    ph.print();
    System.out.println("ph = " + ph);
    assertTrue(ph.getBeginPage()==1);
    assertTrue(ph.getEndPage()==10);
  }
}