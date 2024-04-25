package fr.univrouen.cv24.controllers;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import fr.univrouen.cv24.model.CV24type;
import fr.univrouen.cv24.model.TestCV;
import fr.univrouen.cv24.repositorie.CVRepositorie;
import fr.univrouen.cv24.services.CV2Service;
import fr.univrouen.cv24.util.Fichier;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

@Controller
public class GetController {
	private Marshaller jaxbMarshaller;
	private JAXBContext jaxbContext;
    	@Autowired
	private CV2Service cv24Service;
    @Autowired
	private CVRepositorie cvRepositorie;

    @GetMapping(path = "/cv24/resume", produces = MediaType.TEXT_HTML_VALUE)
    public String listeCV(Model model) {
        List<CV24type> cv24s = cvRepositorie.findAll();

        model.addAttribute("cv24s", cv24s);

        return "cv24Resume";
    }

    @RequestMapping( value="/cv24/resume", method = {RequestMethod.GET, RequestMethod.POST}, 
			produces=MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public String resume() throws TransformerException {
		return cv24Service.getAllCv24s();
	}

    @GetMapping(value="/cv24/xml", produces=MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public String cvXML(@RequestParam Long id) {
		return cv24Service.findById(id);
	}

    @GetMapping(value="/cv24/html", produces=MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public String cvHTML(@RequestParam Long id) {
		return cv24Service.findById(id);
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