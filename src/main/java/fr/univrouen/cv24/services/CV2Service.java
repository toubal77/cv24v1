package fr.univrouen.cv24.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.NoSuchElementException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import fr.univrouen.cv24.Mapper.CV24Mapper;
import fr.univrouen.cv24.model.*;
import fr.univrouen.cv24.repositorie.CVRepositorie;
import fr.univrouen.cv24.util.Validator;
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

        
        public String findById(Long id) throws NoSuchElementException  {
            try {
                CV24type cv24Entity = cvRepositorie.findById(id).get();
                TestCV cv = CV24Mapper.INSTANCE.toModel(cv24Entity);
                return "<message>" + 
                "<id>"+ cv.getIdentite().getNom() +"</id>" + 
                "<status>"+ HttpStatus.OK+"</status>" + 
                "</message>";

            } catch (NoSuchElementException e) {
                return "<message>" + 
                "<id>"+ id +"</id>" + 
                "<status>"+ HttpStatus.NOT_FOUND+"</status>" + 
                "</message>";
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
    