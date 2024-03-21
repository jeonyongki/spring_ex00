package org.ykj.ex00.domain;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PageDTO {
  private int beginPage; //시작페이지
  private int endPage; //끝페이지//total
  private boolean prev, next; //이전,다음

  private int totalCnt;//전체갯수
  private Criteria cri;

  public PageDTO(Criteria cri, int total){
    this.cri = cri;
    this.totalCnt = total;
    this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0)) * 10;
    this.beginPage = this.endPage - 9;

    int realEnd = (int)(Math.ceil((totalCnt*1.0) / cri.getAmount()));
    //endPage=Math.min(endPage, realEnd);
    if(realEnd <= this.endPage){
      this.endPage = realEnd;
    }

    this.prev = this.beginPage > 1;
    this.next = this.endPage < realEnd;
  }
  //검증
  public void print(){
    System.out.println("page = " + cri.getPageNum());
    System.out.print(prev ? "[PREV] " : "");
    for(int i=beginPage; i<=endPage; i++){
      System.out.print(i + " ");
    }
    System.out.println(next ? "[NEXT]" : "");
  }

}
