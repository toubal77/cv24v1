package fr.univrouen.cv24.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.univrouen.cv24.repositorie.CVRepositorie;



@RestController
public class DeleteController {
    @Autowired
	private CVRepositorie cvRepositorie;
	
	@DeleteMapping("/cv24/delete")
	public String deleteCV24(@RequestParam(value = "id")  int id) {
		
		if(cvRepositorie.existsById((long) id)) {
			cvRepositorie.deleteById((long) id);
			
			return "<message>" + 
			"<id>"+ id +"</id>" + 
			"<status>"+ HttpStatus.OK +"</status>" + 
			"</message>";
			
		}else return "<message>" + 
			"<id>"+ id +"</id>" + 
			"<status>"+ HttpStatus.NOT_FOUND+"</status>" + 
			"</message>";
	}
}