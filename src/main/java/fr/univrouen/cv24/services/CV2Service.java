package fr.univrouen.cv24.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.NoSuchElementException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import fr.univrouen.cv24.Mapper.CV24Mapper;
import fr.univrouen.cv24.model.*;
import fr.univrouen.cv24.repositorie.CVRepositorie;
import fr.univrouen.cv24.util.TransformToXML;
import fr.univrouen.cv24.util.Validator;
import jakarta.xml.bind.JAXBException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
@Service
public class CV2Service {

    @Autowired
	private JaxService mapper;
    
        @Autowired
        private CVRepositorie cvRepositorie;
 
	@Autowired
	private Validator validator;
    @Autowired
	private TransformToXML transformer;
    public String getAllCv24s() throws TransformerException {

			return transformer.transformCV24ListXSLResume(mapper.marchall(
					new CV24s(CV24Mapper.INSTANCE.toModels(cvRepositorie.findAll()))));

	}
        
    public String findByIdXML(Long id) throws NoSuchElementException, TransformerException, JAXBException {
		try {
			CV24type cv24 = cvRepositorie.findById(id).get();

            return transformer.transformCV24ListXSLResumeXML(
                CV24Mapper.INSTANCE.toModel(cv24));
		} catch (NoSuchElementException e) {
			return mapper.marchall(new Response(id, Response.Type.ERROR));
		}	

	}

    public String findByIdHTML(Long id) throws NoSuchElementException, TransformerException  {
		try {
			CV24type cv24 = cvRepositorie.findById(id).get();
			return transformer.transformCV24ListXSLResumeHTML(mapper.marchall(cv24));
		} catch (NoSuchElementException e) {
			return mapper.marchall(new Response(id, Response.Type.ERROR));
		}	

	}
    
        public Boolean searchCV24(TestCV cv24) {
            List<CV24type> cvList = cvRepositorie.findAll();

            for (CV24type cv : cvList) {
                if (cv.getIdentite().getGenre().equals(cv24.getIdentite().getGenre()) &&
                    cv.getIdentite().getNom().equals(cv24.getIdentite().getNom()) &&
                    cv.getIdentite().getPrenom().equals(cv24.getIdentite().getPrenom()) &&
                    cv.getIdentite().getTel().equals(cv24.getIdentite().getTel())) {
                    return true;
           
                }
            }
            
            return false;
        }
        
    public String delete(Long id) {
	
            CV24type cv24type = cvRepositorie.findById(id).get();
            if(cv24type != null) {
                cvRepositorie.delete(cv24type);
                
                return "<message>" + 
                "<id>"+ id +"</id>" + 
                "<status>"+ HttpStatus.OK +"</status>" + 
                "</message>";
                
            }else return "<message>" + 
                "<id>"+ id +"</id>" + 
                "<status>"+ HttpStatus.NOT_FOUND+"</status>" + 
                "</message>";
        }



	
        public String insert(TestCV cv24) {
     if(cv24 !=null){
        //    Boolean response = validator.validateCV24(cv24);
         //   if(response){
                     if (searchCV24(cv24)) {
                        return mapper.marchall(new Response(Response.Type.ERROR, "Flux déjà existant !"));
                     
                     }
                     CV24type cv =    cvRepositorie.save(CV24Mapper.INSTANCE.toEntity(cv24));
                 	return mapper.marchall(new Response(cv.getId(), Response.Type.INSERTED));
         //           }else{
          //              return  "<message>" + 
           //             "xml format no valide"+				
           //     "<status>"+ HttpStatus.CONFLICT +"</status>" + 
           // "</message>";
           //         }
            } else {
                return mapper.marchall(new Response(Response.Type.ERROR));
            }
        }
        

    }
    