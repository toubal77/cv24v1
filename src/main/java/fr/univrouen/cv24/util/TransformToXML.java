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

@Component
public class TransformToXML {
	

	
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

	public String transformCV24ListXSLResumeHTML(String cv24s) throws TransformerException {
		TransformerFactory tFactory = new TransformerFactoryImpl();
	
		Transformer transformer = tFactory.newTransformer(new StreamSource(getClass().getResourceAsStream("/html.xslt")));
		
		StringWriter sw = new StringWriter();
				
		transformer.transform(new StreamSource(new StringReader(cv24s)), new StreamResult(sw));
		
		return sw.toString();
		
	}
	
	

}