package org.ykj.ex00.mappers;

import org.ykj.ex00.domain.BoardVO;
import org.ykj.ex00.domain.Criteria;

import java.util.List;

public interface BoardMapper {
  int insert(BoardVO boardVO);

  List<BoardVO> getList();

  List<BoardVO> getPage(Criteria criteria);

  BoardVO select(Long bno);

  int update(BoardVO boardVO);
}
