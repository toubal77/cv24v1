package fr.univrouen.cv24.controllers;

import java.io.InputStream;

import java.util.NoSuchElementException;

import javax.xml.transform.TransformerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import fr.univrouen.cv24.model.TestCV;
import fr.univrouen.cv24.services.CV2Service;
import fr.univrouen.cv24.util.Fichier;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

@Controller
public class GetController {

	private CV2Service cv24Service;
  



	@RequestMapping( value="/cv24/resume", method = {RequestMethod.GET, RequestMethod.POST}, 
			produces=MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public String resume() throws TransformerException {
		return cv24Service.getAllCv24s();
	}

    @GetMapping(value="/cv24/resume/xml", produces=MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public String cvXML(@RequestParam Long id) throws NoSuchElementException, TransformerException, JAXBException {
		return cv24Service.findByIdXML(id);
	}

    @GetMapping(value="/cv24/resume/html", produces=MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public String cvHTML(@RequestParam Long id) throws NoSuchElementException, TransformerException {
		return cv24Service.findByIdHTML(id);
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