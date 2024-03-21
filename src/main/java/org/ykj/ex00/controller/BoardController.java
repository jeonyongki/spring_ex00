package org.ykj.ex00.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.ykj.ex00.domain.BoardVO;
import org.ykj.ex00.domain.Criteria;
import org.ykj.ex00.service.BoardService;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

  private final BoardService boardService;

//  //list
//  @GetMapping("/list")
//  public void list(Model model){
//    log.info("list------------------------------------------------------------>");
//    List<BoardVO> list = boardService.list();
//    log.info(" >> "+list);
//    model.addAttribute("list", list);
//  }
  //list
  @GetMapping("/list")
  public void list(@ModelAttribute("cri") Criteria criteria, Model model){
    log.info("list---------------------------------------------------------------------------->");
    List<BoardVO> pageList = boardService.getPage(criteria);
    log.info(" >> "+pageList);
    model.addAttribute("list", pageList);
  }

  @GetMapping({"/{job}/{bno}"})
  public String read(@PathVariable(name="job")String job, @PathVariable(name="bno") Long bno, Model model){
    log.info("read() job : "+job);
    log.info("read() bno : "+bno);

    if( !(job.equals("read") || job.equals("modify")) ){
      throw new RuntimeException("Bad Request job");
    }
    BoardVO boardVO = boardService.get(bno);
    log.info("boardVO : "+boardVO);
    model.addAttribute("vo", boardVO);

    return "/board/"+job;
  }

  @GetMapping("/register")
  public void register(){
    log.info("register()----------------------------------------------------------->");
  }

  @PostMapping("/register")
  public String registerPost(BoardVO boardVO, RedirectAttributes redirectAttributes){
    log.info("register() boardVO:"+ boardVO);
    Long bno = boardService.register(boardVO);
    redirectAttributes.addFlashAttribute("bno", bno);
    return "redirect:/board/list";
  }

  @PostMapping("/remove/{bno}")
  public String remove(@PathVariable(name="bno") Long bno, RedirectAttributes redirectAttributes){
    log.info("remove() bno:"+ bno);
    BoardVO boardVO = BoardVO.builder()
                    .bno(bno)
                    .title("해당 글은 삭제 되었습니다..")
                    .content("해당 글은 삭제 되었습니다..")
                    .writer("unknown").build();
    log.info(" >> "+boardVO);
    boardService.modify(boardVO);
    redirectAttributes.addFlashAttribute("bno", boardVO.getBno());
    return "redirect:/board/list";
  }

  @PostMapping("/modify/{bno}")
  public String modify(@PathVariable(name="bno") Long bno, BoardVO boardVO){

    log.info("modify() bno:"+ bno);

    boardVO.setBno(bno);

    log.info(" >> "+boardVO);
    boardService.modify(boardVO);

    return "redirect:/board/read/"+bno;
  }

}
