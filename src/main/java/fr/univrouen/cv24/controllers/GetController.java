package fr.univrouen.cv24.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {
@GetMapping("/resume")
public String getListCVinXML() {
return "Envoi de la liste des CV";
}
@GetMapping("/cvid")
public String getCVinXML(
@RequestParam(value = "texte") String texte) {
		return ("Détail du CV n°" + texte);
}

@GetMapping("/test")
public String getTestinXML(
        @RequestParam(value = "id", required = false) Integer id,
        @RequestParam(value = "titre", required = false) String titre) {
	String idString = (id != null) ? id.toString() : "null";
    String titreString = (titre != null) ? titre : "null";
    if(idString == "null" && titreString =="null") {
    return "Page test sans parametre";
    }else {
    	return "Test :\n" + "id = " + id + "\n" + "titre = " + titre;
    }
}
}