package fr.univrouen.cv24.util;

import java.io.IOException;
import java.io.StringReader;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

import fr.univrouen.cv24.controllers.PostController;


public class Validator {

    public boolean validate(String stb20) throws DisplayMessageException {
        try {
        	
        	SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(PostController.class.getResource("/xsd/cv24.xsd"));
            javax.xml.validation.Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new StringReader(stb20)));
        
            return true;

        } catch (SAXException exp) {
        	throw new DisplayMessageException(exp.getMessage()+exp);
        } catch (IOException exp) {
        	throw new DisplayMessageException(exp.getMessage()+exp);
        }
    }
}
