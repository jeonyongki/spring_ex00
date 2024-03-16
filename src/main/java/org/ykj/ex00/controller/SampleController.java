package org.ykj.ex00.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.ykj.ex00.domain.SampleDTO;
import org.ykj.ex00.domain.SampleDTOList;
import org.ykj.ex00.domain.TodoDTO;

import java.util.Arrays;

@Controller
@Log4j2
@RequestMapping("/sample")
public class SampleController {

  @GetMapping("/basic")
  public void basic(){
    log.info("basic----------------");
  }

  @GetMapping("/ex1")
  public void ex1(SampleDTO sampleDTO){
    log.info("ex1-------------");
    log.info(sampleDTO);
  }
//  @GetMapping("/ex1")
//  public void ex1(@RequestParam("name") String name,
//                  @RequestParam(value = "age",required = false, defaultValue = "10") int age){
//    log.info("ex1--------------------------------------");
//    log.info(name);
//    log.info(age);
//  }

  @GetMapping("/ex02Array")
  public String ex02Array(String[] ids){
    log.info("====================");
    log.info(Arrays.toString(ids));
    return "/sample/ex2";
  }

  @GetMapping("ex02Bean")
  public void ex02Bean(SampleDTOList list){
    log.info(list);
  }

  @GetMapping("/ex03")
  public void ex03(TodoDTO todoDTO){
    log.info("----------------------");
    log.info(todoDTO);
  }

  @GetMapping("/ex04")
  public void ex04(@ModelAttribute("page") int page, Model model){
    model.addAttribute("list", new String[]{"aaa", "bbb", "ccc"});
  }
}
