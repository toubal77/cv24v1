package fr.univrouen.cv24.services;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


import org.springframework.stereotype.Service;

import fr.univrouen.cv24.model.CV24type;
import fr.univrouen.cv24.model.TestCV;



@Service
public class JaxService {
	
	public String marchall(TestCV cv24) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(TestCV.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			StringWriter sw = new StringWriter();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			jaxbMarshaller.marshal(cv24, sw);
			return sw.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}