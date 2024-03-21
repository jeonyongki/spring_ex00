package org.ykj.ex00.domain;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PageHandler {
  private int totalCnt;//총 게시물 갯수
  private int pageSize;//한 페이지의 크기 amount
  private int naviSize = 10;//페이지 네비 크기
  private int totalPage;//전체 페이지의 갯수
  private int page; //현제 페이지
  private int beginPage; //네비 첫번째 페이지
  private int endPage;//네비 마지막 페이지
  private boolean showPrev; //이전페이지 존재 여부
  private boolean showNext; //다음페이지 존재 여부

  //총게시물과 페이지값만
  public PageHandler(int totalCnt, int page){
    this(totalCnt, page, 10);
  };
  public PageHandler(int totalCnt, int page, int pageSize){
    this.totalCnt =totalCnt;
    this.page = page;
    this.pageSize = pageSize;

    //전체페이지(소수점 올림)
    totalPage = (int)Math.ceil((double) totalCnt / pageSize);
    //네비 첫페이지
    beginPage = ((page-1) / naviSize)*naviSize +1;
    //네비 끝페이지
    endPage = Math.min( (beginPage+naviSize)-1, totalPage);
    //네비 표시(시작페이지가 1이면 생략)
    showPrev = beginPage!=1;
    showNext = endPage!=totalPage;//마지막페이지면 생략

  }

  public void print(){
    System.out.println("page = " + page);
    System.out.print(showPrev ? "[PREV] " : "");
    for(int i=beginPage; i<=endPage; i++){
      System.out.print(i + " ");
    }
    System.out.println(showNext ? " [NEXT]" : "");
  }
}
