package fr.univrouen.cv24.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.xml.transform.TransformerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univrouen.cv24.Mapper.CV24Mapper;
import fr.univrouen.cv24.model.*;
import fr.univrouen.cv24.repositorie.CVRepositorie;
import fr.univrouen.cv24.util.DisplayMessageException;
import fr.univrouen.cv24.util.TransformToXML;
import fr.univrouen.cv24.util.Validateur;
import jakarta.xml.bind.JAXBException;

@Service
public class CV2Service {

    @Autowired
	private JaxService mapper;
    
        @Autowired
        private CVRepositorie cvRepositorie;
 
	@Autowired
	private Validateur validator;

    @Autowired
	private TransformToXML transformer;
   
    public String getAllCv24sHTML() {
        try {
            List<CV24type> cv24 = cvRepositorie.findAll();
         //   System.out.println("getAllCv24sHTML()");
        if (cv24.isEmpty()) {
         //   System.out.println("getAllCv24sHTML() aucun");
            String errorMessage = "<strong>Error:</strong>Il n'y a aucun CV dans la base de données pour le moment";
            String errorHtml  = new DisplayMessageException().loadHtmlTemplateErreur();
            errorHtml = errorHtml.replace("<p id=\"error-message\"></p>", "<p id=\"error-message\">" + errorMessage + "</p>");
            return errorHtml;
        } else {
            List<CV24> CV24List = CV24Mapper.INSTANCE.toModels(cv24);
            return transformer.transformCV24ListXSLResumeHTMLList(CV24List);
        }
    } catch (NoSuchElementException e) {
        return "errorHtml";
    }
    }
   
    public String getAllCv24sXML() throws TransformerException {
        try {
            List<CV24type> cv24s = cvRepositorie.findAll();
         //   System.out.println("getAllCv24sXML()");
            if (cv24s.isEmpty()) {
           //     System.out.println("getAllCv24sXML() aucun");
                return mapper.marchall(new Response( Response.Type.NONE,"Il n'y a aucun CV dans la base de données pour le moment"));
            } else {
                return transformer.transformCV24ListXSLResume(CV24Mapper.INSTANCE.toModels(cv24s));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    


    public String findByIdXML(Long id) throws NoSuchElementException, TransformerException, JAXBException  {
		try {
			CV24type cv24 = cvRepositorie.findById(id).get();
		
			 return transformer.transformCV24ListXSLResumeXML(
                CV24Mapper.INSTANCE.toModel(cv24));
		} catch (NoSuchElementException e) {
			return mapper.marchall(new Response(id, Response.Type.ERROR));
		}	

	}

   public String findByIdHTML(Long id) {
    try {
        CV24type cv24 = cvRepositorie.findById(id).get();
        return transformer.transformCV24ListXSLResumeHTML(CV24Mapper.INSTANCE.toModel(cv24));
    } catch (NoSuchElementException e) {
        String errorMessage = "<strong>Error:</strong>Il n'y a aucun CV avec ID " + id;
        String errorHtml = new DisplayMessageException().loadHtmlTemplateErreur();
        errorHtml = errorHtml.replace("<p id=\"error-message\"></p>", "<p id=\"error-message\">" + errorMessage + "</p>");
        return errorHtml;
    }
}


    
        public Boolean searchCV24(CV24 cv24) {
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
            if (id != null) {
                try {
                    CV24type cv24type = cvRepositorie.findById(id).get();
                    if (cv24type != null) {
                        cvRepositorie.delete(cv24type);
                        return mapper.marchall(new Response(id, Response.Type.DELETED));
                    } else {
                        return mapper.marchall(new Response(Response.Type.ERROR, "CV Non trouvé"));
                    }
                } catch (NoSuchElementException e) {
                    return mapper.marchall(new Response(Response.Type.ERROR, "CV Non trouvé"));
                }
            } else {
                return mapper.marchall(new Response(Response.Type.ERROR, "Veuillez indiquer l'ID du CV à supprimer"));
            }
        }
        

	
        public String insert(CV24 cv24) {
     if(cv24 !=null){
            Boolean response = validator.validateCV24(cv24);
           if(response){
                     if (searchCV24(cv24)) {
                        return mapper.marchall(new Response(Response.Type.DUPLICATED, "Flux déjà existant !"));
                     
                     }
                     CV24type cv =    cvRepositorie.save(CV24Mapper.INSTANCE.toEntity(cv24));
                 	return mapper.marchall(new Response(cv.getId(), Response.Type.INSERTED));
                    }else{
                        return mapper.marchall(new Response(Response.Type.ERROR,"Erreur inattendue lors de la validation du schéma XML (XML non valide)"));
                    }
            } else {
                return mapper.marchall(new Response(Response.Type.ERROR));
            }
        }
        

    }
    