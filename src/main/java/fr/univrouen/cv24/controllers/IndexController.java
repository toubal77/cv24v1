package fr.univrouen.cv24.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = "/")
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
}
