package fr.univrouen.cv24.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import fr.univrouen.cv24.model.TestCV;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

@Component
public class Validator {

    public static final String SCHEMA_LANGUAGE = "http://www.w3.org/2001/XMLSchema";
    public static final String CV24_XSD_FILE = "/cv24.xsd";

    public Boolean validateCV24(TestCV cv24) {
        SimpleErrorHandler errorHandler = new SimpleErrorHandler(); 

        try {
            // Créer le contexte JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(TestCV.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            StringWriter writer = new StringWriter();
            marshaller.marshal(cv24, writer);
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            factory.setNamespaceAware(true);
            
            DocumentBuilder builder = factory.newDocumentBuilder();
          //  builder.setErrorHandler(errorHandler);
            

            Document document = builder.parse(new InputSource(new StringReader(writer.toString())));
            
            SchemaFactory schemaFactory = SchemaFactory.newInstance(SCHEMA_LANGUAGE);
            Schema schema = schemaFactory.newSchema(new StreamSource(getClass().getResourceAsStream(CV24_XSD_FILE)));
            

            javax.xml.validation.Validator validator = schema.newValidator();
            // Valider le Document
            validator.validate(new DOMSource(document));
            return true;
        } catch (JAXBException | ParserConfigurationException | SAXException | IOException e) {
            System.out.println("ereurrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
            System.out.println(e);
            return false;
        } 
        
    }
}