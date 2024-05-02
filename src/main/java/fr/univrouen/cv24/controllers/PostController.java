package fr.univrouen.cv24.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import fr.univrouen.cv24.model.TestCV;
import fr.univrouen.cv24.services.CV2Service;

@RestController
public class PostController {

	@Autowired
	private CV2Service cv24Service;


		@RequestMapping(value = "/cv24/insert", method = RequestMethod.POST, consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
		public String insert(@RequestBody TestCV cv24) {
			return cv24Service.insert(cv24);
		}
}