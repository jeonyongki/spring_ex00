package org.ykj.ex00.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.ykj.ex00.domain.BoardVO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
class BoardServiceTest {
  @Autowired
  BoardService boardService;

  @Test
  public void listTest(){
    List<BoardVO> list = boardService.list();
    log.info("list : "+list);
    list.forEach(boardVO -> log.info(boardVO));
  }
  @Test
  public void modifyTest(){
    BoardVO boardVO = BoardVO.builder()
        .title("테스트글2")
        .content("no content")
        .bno(2L)
        .build();
    boolean isState = boardService.modify(boardVO);
    log.info(isState ? "성공" : "실패");
  }
}