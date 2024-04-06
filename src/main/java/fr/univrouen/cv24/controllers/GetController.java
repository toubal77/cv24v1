package fr.univrouen.cv24.controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
//import java.awt.PageAttributes.MediaType;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import model.Objectif;
import model.TestCV;
import util.Fichier;

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

@GetMapping("/testfic")
public String afficherContenuFichier() {
    return Fichier.loadFileXML();
}

@RequestMapping(value="/testxml", produces=MediaType.APPLICATION_XML_VALUE)
public @ResponseBody TestCV getXML() {
    try {
        JAXBContext context = JAXBContext.newInstance(TestCV.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("smallCV.xml");

        TestCV cv = (TestCV) unmarshaller.unmarshal(inputStream);

        return cv;
    } catch (JAXBException e) {
        e.printStackTrace();
        return null;
    }
}


}