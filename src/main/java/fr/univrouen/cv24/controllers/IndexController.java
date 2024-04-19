package fr.univrouen.cv24.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

 /*   @GetMapping("/help")
    public String help(Model model) {
        return "index";
    }

    @GetMapping("/error")
    public String error() {
        return "index";
    } */
}
