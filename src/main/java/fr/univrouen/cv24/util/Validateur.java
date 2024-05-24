package fr.univrouen.cv24.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.IOException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import fr.univrouen.cv24.model.CV24;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import javax.xml.validation.Validator;
@Component
public class Validateur {

    public static final String SCHEMA_LANGUAGE = "http://www.w3.org/2001/XMLSchema";
    public static final String CV24_XSD_FILE = "/cv24.xsd";

      public Boolean validateCV24(CV24 cv24) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CV24.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter writer = new StringWriter();
            marshaller.marshal(cv24, writer);
            String xmlData = writer.toString();

            SchemaFactory schemaFactory = SchemaFactory.newInstance(SCHEMA_LANGUAGE);
            Schema xsdSchema = schemaFactory.newSchema(getClass().getResource(CV24_XSD_FILE));
       //     System.out.println("xmlDataaaaaaaaaaaaaaaaa" + xmlData);

            Validator validator = xsdSchema.newValidator();
            validator.validate(new StreamSource(new StringReader(xmlData)));
           // System.out.println( "valide tropppppppppppppp biennnnnnnnnnnnnnnn");
            return true; 
        } catch (JAXBException | SAXException | IOException e) {
       //     System.out.println( "Erreur inattendue lors de la validation du schéma XML");
                return false;
        
        }
    }
}