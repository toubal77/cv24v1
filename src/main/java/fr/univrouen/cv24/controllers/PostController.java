package fr.univrouen.cv24.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	 @PostMapping(value = "/testpost", consumes = "application/xml")
	    public String postTest(@RequestBody String flux) {
	        return "<result><response>Message reçu : </response>" + flux + "</result>";
	    }
}
