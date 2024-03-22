package org.ykj.ex00.mappers;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.ykj.ex00.domain.BoardVO;
import org.ykj.ex00.domain.Criteria;
import org.ykj.ex00.domain.PageDTO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
class BoardMapperTest {
  @Autowired(required = false)
  BoardMapper boardMapper;
  @Test
  public void test1(){
    log.info(boardMapper);
  }

  @Test
  public void insertTest(){
    for(int i=1; i<=1000; i++) {
      BoardVO boardVO = BoardVO.builder()
          .title("test"+i)
          .content("no content"+i)
          .writer("tester")
          .build();
      log.info("COUNT : " + boardMapper.insert(boardVO));
      log.info("bno : " + boardVO.getBno());
    }
  }

  @Test
  public void listTest(){
    boardMapper.getList().forEach(boardVO -> log.info(boardVO));
  }
  @Test
  public void selectTest(){
    log.info(boardMapper.select(2L));
  }

  @Test
  public void updateTest(){
    BoardVO boardVO = BoardVO.builder()
        .title("테스트글3")
        .content("no content")
        .bno(3L)
        .build();
    log.info("COUNT : "+boardMapper.update(boardVO));
    log.info("UPDATE : "+boardMapper.select(boardVO.getBno()));
  }
  @Test
  public void pageTest(){
    Criteria criteria = new Criteria();
    //1, 10
    criteria.setPageNum(5);

    List<BoardVO> page = boardMapper.getPage(criteria);
    page.forEach(boardVO -> log.info(boardVO));
  }
  @Test
  public void pageTest2(){
    Criteria criteria = new Criteria();
    //1, 10
    criteria.setPageNum(25);
    PageDTO pageDTO = new PageDTO(criteria, 255);
    pageDTO.print();
    System.out.println("pageDTO = " + pageDTO);
    assertTrue(pageDTO.getBeginPage()==21);
    assertTrue(pageDTO.getEndPage()==26);
  }
  @Test
  public void pageTest3(){
    Criteria criteria = new Criteria();
    //1, 10
    criteria.setPageNum(11);
    PageDTO pageDTO = new PageDTO(criteria, 255);
    pageDTO.print();
    System.out.println("pageDTO = " + pageDTO);
    assertTrue(pageDTO.getBeginPage()==11);
    assertTrue(pageDTO.getEndPage()==20);
  }

}