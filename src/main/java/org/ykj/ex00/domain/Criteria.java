package org.ykj.ex00.domain;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Criteria {
  private int pageNum = 1;
  private int amount  =10;

  //null, T, C, W, TC, TW, TCW
  private String[] types;
  private String keyword;

  public void setPageNum(int pageNum) {
    if(pageNum <= 0) pageNum =1;
    this.pageNum = pageNum;
  }

  public void setAmount(int amount) {
    if(amount < 10 || amount > 100) amount = 10;
    this.amount = amount;
  }
  //mybatis 에서 skip 이라는 변수로 호출
  public int getSkip(){
    return (this.pageNum-1) * this.amount;
  }
}
