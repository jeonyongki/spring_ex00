package org.ykj.ex00.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ykj.ex00.domain.BoardVO;
import org.ykj.ex00.domain.Criteria;
import org.ykj.ex00.mappers.BoardMapper;

import java.util.List;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class BoardService {

  private final BoardMapper boardMapper;

  public Long register(BoardVO boardVO){
    log.info("--------------"+boardVO);
    int count = boardMapper.insert(boardVO);

    return boardVO.getBno();
  }

  public List<BoardVO> list(){
    return boardMapper.getList();
  }
  public List<BoardVO> getPage(Criteria criteria){
    return boardMapper.getPage(criteria);
  }

  public BoardVO get(Long bno){
    return boardMapper.select(bno);
  }

  public boolean modify(BoardVO boardVO){
    return boardMapper.update(boardVO) == 1;
  }

  public boolean remove(Long bno){
    return true;
  }
}
