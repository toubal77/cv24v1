package fr.univrouen.cv24.services;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


import org.springframework.stereotype.Service;

import fr.univrouen.cv24.model.CV24s;
import fr.univrouen.cv24.model.CV24type;
import fr.univrouen.cv24.model.Response;
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

	public String marchall(CV24type cv24) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(CV24type.class);
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

	public String marchall(Response response) {
		try {
			Marshaller jaxbMarshaller = JAXBContext.newInstance(Response.class).createMarshaller();
			StringWriter sw = new StringWriter();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			jaxbMarshaller.marshal(response, sw);
			return sw.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}


	public String marchall(CV24s cv24s) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(CV24s.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			StringWriter sw = new StringWriter();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			jaxbMarshaller.marshal(cv24s, sw);
			return sw.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}

}