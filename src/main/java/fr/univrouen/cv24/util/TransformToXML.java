package fr.univrouen.cv24.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

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
@Component
public class TransformToXML {
	

    public String transformCV24ListXSLResume(List<TestCV> list) throws TransformerException {
        try {
         //   System.out.println("lllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
            System.out.println(list);
            JAXBContext jaxbContext = JAXBContext.newInstance(CV24ListWrapper.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    
            // Encapsulate the list in a wrapper object
            CV24ListWrapper wrapper = new CV24ListWrapper();
            wrapper.setTestCVs(list);
          //  System.out.println("gggggggggggggggggggggggggggggggggggggggggggggggggg");
            System.out.println(wrapper.getTestCVs());
            // Marshall the wrapper object
            StringWriter writer = new StringWriter();
            marshaller.marshal(wrapper, writer);
    
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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


    public String transformCV24ListXSLResumeHTMLList(List<TestCV> list) {
        try {
          
            Cv24sListWrapper wrapper = new Cv24sListWrapper();
            wrapper.setCv24List(list);
            

            JAXBContext jaxbContext = JAXBContext.newInstance(Cv24sListWrapper.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            StringWriter xmlWriter = new StringWriter();
            marshaller.marshal(wrapper, xmlWriter);
            
      
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            StreamSource xsltSource = new StreamSource(getClass().getResourceAsStream("/cv24s.xslt"));
            
            Transformer transformer = transformerFactory.newTransformer(xsltSource);
            StreamSource xmlSource = new StreamSource(new StringReader(xmlWriter.toString()));
            StringWriter htmlWriter = new StringWriter(); 
            transformer.transform(xmlSource, new StreamResult(htmlWriter));
            
            String htmlContent = htmlWriter.toString(); 
            System.out.println("Transformation XML vers HTML terminée.");
            
            return htmlContent;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String transformCV24ListXSLResumeHTML(TestCV testCV) {
        try {
            // Marshalliser un objet en XML
            JAXBContext jaxbContext = JAXBContext.newInstance(TestCV.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
    
            StringWriter xmlWriter = new StringWriter();
            marshaller.marshal(testCV, xmlWriter);
    
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            StreamSource xsltSource = new StreamSource(getClass().getResourceAsStream("/html.xslt"));
    
   
            Transformer transformer = transformerFactory.newTransformer(xsltSource);
            StreamSource xmlSource = new StreamSource(new StringReader(xmlWriter.toString()));
            //System.out.println(xmlSource);
            StringWriter htmlWriter = new StringWriter(); 
            transformer.transform(xmlSource, new StreamResult(htmlWriter));
           
            String htmlContent = htmlWriter.toString(); 
            System.out.println("Transformation XML vers HTML terminée.");
            
            return htmlContent;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }}
    

}