package fr.univrouen.cv24.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping(value =  {"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping(value = "/help")
    public String help() {
        return "help";
    }
 
    @GetMapping(value = "/error")
    public String error() {
        return "error";
    }
    
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
       ModelAndView modelAndView = new ModelAndView();
      modelAndView.setViewName("error");
        return modelAndView;
    }
}
