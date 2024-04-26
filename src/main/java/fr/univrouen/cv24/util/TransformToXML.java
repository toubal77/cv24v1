package fr.univrouen.cv24.util;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Component;

import fr.univrouen.cv24.model.TestCV;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import net.sf.saxon.TransformerFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
public class TransformToXML {
	
	@Autowired
    private TemplateEngine templateEngine;
	
	public String transformCV24ListXSLResume(String cv24s) throws TransformerException {
		TransformerFactory tFactory = new TransformerFactoryImpl();
	
		Transformer transformer = tFactory.newTransformer(new StreamSource(getClass().getResourceAsStream("/cv24s.xslt")));
		
		StringWriter sw = new StringWriter();
				
		transformer.transform(new StreamSource(new StringReader(cv24s)), new StreamResult(sw));
		
		return sw.toString();
		
	}
	
	public String transformCV24ListXSLResumeXML(TestCV cv24s) throws TransformerException, JAXBException {
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(TestCV.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    
            StringWriter writer = new StringWriter();
            marshaller.marshal(cv24s, writer);

           
            return writer.toString();
        } catch (Exception e) {
          
            e.printStackTrace();
            return null; 
        }
    }
    
	public String transformCV24ListXSLResumeHTML(TestCV testCV) {

        try {
            // Créer un contexte Thymeleaf et ajouter l'objet TestCV au modèle
            Context context = new Context();
            context.setVariable("testCV", testCV);

            // Utiliser le moteur de template Thymeleaf pour traiter le modèle et générer du HTML
            String htmlContent = templateEngine.process("cv24_html", context);

            return htmlContent;
        } catch (Exception e) {
            // Gérer les exceptions ici
            e.printStackTrace();
            return null; // Ou une chaîne d'erreur personnalisée
        }
    }


}

	public String transformCV24ListXSLResumeHTML(String cv24s) throws TransformerException {
		TransformerFactory tFactory = new TransformerFactoryImpl();
	
		Transformer transformer = tFactory.newTransformer(new StreamSource(getClass().getResourceAsStream("/html.xslt")));
		
		StringWriter sw = new StringWriter();
				
		transformer.transform(new StreamSource(new StringReader(cv24s)), new StreamResult(sw));
		
		return sw.toString();
		
	}
	
	

}