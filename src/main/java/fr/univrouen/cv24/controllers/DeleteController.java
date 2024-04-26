package fr.univrouen.cv24.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.univrouen.cv24.model.Response;
import fr.univrouen.cv24.services.CV2Service;
import fr.univrouen.cv24.services.JaxService;



@RestController
public class DeleteController {
   @Autowired
	private CV2Service cv24Service;
	
	
	@DeleteMapping(value="/cv24/delete")
	public String delete(@RequestParam Long id) {
		return cv24Service.delete(id);		
	}
}