package fr.univrouen.cv24.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import fr.univrouen.cv24.model.TestCV;
import fr.univrouen.cv24.services.CV2Service;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

@RestController
public class PostController {

	@Autowired
	private CV2Service cv24Service;

	
	JAXBContext jaxbContext;
    Unmarshaller jaxbUnmarshaller;

	 @PostMapping(value = "/testpost", consumes = "application/xml")
	    public String postTest(@RequestBody String flux) {
	        return "<result><response>Message reçu : </response>" + flux + "</result>";
	    }
		@RequestMapping(value = "/cv24/insert", method = RequestMethod.POST, consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
		public String insert(@RequestBody TestCV cv24) {
			return cv24Service.insert(cv24);
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