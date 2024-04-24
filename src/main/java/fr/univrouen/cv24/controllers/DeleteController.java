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
	  @Autowired
	private JaxService mapper;
	
	@DeleteMapping(value = "/cv24/delete")
public String delete(@RequestParam(required = false) Long id) {
    try {
        if (id == null) {
            throw new IllegalArgumentException("Veuillez indiquer l'ID du CV à supprimer");
        }
        return cv24Service.delete(id);
    } catch (Exception e) {
        return mapper.marchall(new Response(Response.Type.ERROR, e.getMessage()));
    }
}

}