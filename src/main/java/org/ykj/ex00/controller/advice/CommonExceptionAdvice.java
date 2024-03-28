package org.ykj.ex00.controller.advice;

import lombok.extern.log4j.Log4j2;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {
  public String exceptNumber(NumberFormatException exception, Model model){
    log.error("---------------------------------------------------------");
    log.error(exception.getMessage());

    model.addAttribute("msg", "Number Check");

    return "error_page";
  }
}
