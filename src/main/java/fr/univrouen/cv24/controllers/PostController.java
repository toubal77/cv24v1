package fr.univrouen.cv24.controllers;

import java.io.StringReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import fr.univrouen.cv24.model.AutreType;
import fr.univrouen.cv24.model.CV24;
import fr.univrouen.cv24.model.CV24type;
import fr.univrouen.cv24.model.CertifType;
import fr.univrouen.cv24.model.CompetencesType;
import fr.univrouen.cv24.model.CrtType;
import fr.univrouen.cv24.model.DetailType;
import fr.univrouen.cv24.model.DiplomeType;
import fr.univrouen.cv24.model.DiversType;
import fr.univrouen.cv24.model.GenreType;
import fr.univrouen.cv24.model.IdentiteType;
import fr.univrouen.cv24.model.LvType;
import fr.univrouen.cv24.model.NivsType;
import fr.univrouen.cv24.model.ObjectifType;
import fr.univrouen.cv24.model.ProfType;
import fr.univrouen.cv24.model.StatutType;
import fr.univrouen.cv24.model.TestCV;
import fr.univrouen.cv24.repositorie.CVRepositorie;
import fr.univrouen.cv24.services.CV2Service;
import fr.univrouen.cv24.util.DisplayMessageException;
import fr.univrouen.cv24.util.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

@RestController
public class PostController {

	@Autowired
	private CV2Service stbService;
	@Autowired
	private CVRepositorie cvRepositorie;
	
	JAXBContext jaxbContext;
    Unmarshaller jaxbUnmarshaller;

	 @PostMapping(value = "/testpost", consumes = "application/xml")
	    public String postTest(@RequestBody String flux) {
	        return "<result><response>Message reçu : </response>" + flux + "</result>";
	    }
		@RequestMapping(value = "/cv24/insert", method = RequestMethod.POST, consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
		public String insert(@RequestBody TestCV cv24) {
			return stbService.insert(cv24);
		}
// 	@RequestMapping(value = "/cv24/insert", method = RequestMethod.POST, consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
// 	public String insert(@RequestBody String cv24) throws DisplayMessageException {
	
// 	 Validator cv24Validator = new Validator();
	 
// 		try {
			
			
// 			cv24Validator.validate(cv24);
			
//             jaxbContext = JAXBContext.newInstance(CV24type.class, AutreType.class, CertifType.class, CompetencesType.class, 
//             		CrtType.class, DetailType.class, DiplomeType.class, DiversType.class, GenreType.class, IdentiteType.class, LvType.class,
// 					NivsType.class, ObjectifType.class, ProfType.class, StatutType.class);
            
//             jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            
//             CV24type cv24Object = (CV24type) jaxbUnmarshaller.unmarshal(new StringReader(cv24));
			
//             CV24type cv24Response = cvRepositorie.save(cv24Object);
            
// 		    if(cv24Response != null) return "<message>" + 
// 									"<id>"+ cv24Object.getId() +"</id>" + 
// 									"<status>"+ HttpStatus.OK +"</status>" + 
// 									"</message>";
	        
// 		    else return "<message>" + 
// 						"<status>"+ HttpStatus.NOT_ACCEPTABLE +"</status>" + 
// 						"</message>";
	
// 		} catch (Exception exp) {
// 			throw new DisplayMessageException(exp.getMessage()+exp);
// 		}
	
// }
}