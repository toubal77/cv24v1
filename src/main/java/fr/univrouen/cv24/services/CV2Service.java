package fr.univrouen.cv24.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import fr.univrouen.cv24.Mapper.CV24Mapper;
import fr.univrouen.cv24.model.CV24type;
import fr.univrouen.cv24.model.TestCV;
import fr.univrouen.cv24.repositorie.CVRepositorie;

@Service
public class CV2Service {

      
    
        @Autowired
        private CVRepositorie cvRepositorie;
        
       
    
    
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
        
        
                     if (searchCV24(cv24)) {
                        return  "<message>" + 
                    							
                        "<status>"+ HttpStatus.CONFLICT +"</status>" + 
                    "</message>";
                     }
                 cvRepositorie.save(CV24Mapper.INSTANCE.toEntity(cv24));
                    return  "<message>" + 
                    								
                     									"<status>"+ HttpStatus.OK +"</status>" + 
                 									"</message>";
    
           // } else {
           //     return mapper.marchall(new Response(Response.Type.ERROR));
           // }
        }
        

    }
    