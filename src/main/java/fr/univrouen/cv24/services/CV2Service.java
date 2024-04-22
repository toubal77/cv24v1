package fr.univrouen.cv24.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import fr.univrouen.cv24.Mapper.CV24Mapper;
import fr.univrouen.cv24.model.CV24;
import fr.univrouen.cv24.model.CV24type;
import fr.univrouen.cv24.model.TestCV;
import fr.univrouen.cv24.repositorie.CVRepositorie;

@Service
public class CV2Service {
    
     
      
    
        @Autowired
        private CVRepositorie stbRepository;
        
       
    
    

    
        public String insert(TestCV stb) {
            if (stb != null)  {
            //    Response response = validator.validateStb(mapper.marchall(stb));
            //    if (response.getStatus() == Response.Type.OK) {
                    // if (stbRepository.findByTitleAndVersion(stb.getTitle(), stb.getVersion()) != null) {
                    //     return mapper.marchall(new Response(Response.Type.ERROR, "Flux déjà existant !"));
                    // }
                    CV24type stbEntity = stbRepository.save(CV24Mapper.INSTANCE.toEntity(stb));
                    return  "<message>" + 
                    								
                     									"<status>"+ HttpStatus.OK +"</status>" + 
                 									"</message>";
                } else {
                    return  "<message>" + 
                    								
                    "<status>"+ HttpStatus.CONFLICT +"</status>" + 
                "</message>";
                }
           // } else {
           //     return mapper.marchall(new Response(Response.Type.ERROR));
           // }
        }
        

    }
    