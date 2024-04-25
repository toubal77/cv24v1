package fr.univrouen.cv24.util;


import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Component;

import net.sf.saxon.TransformerFactoryImpl;

@Component
public class TransformToXML {



	public String transformCV24ListXSLResume(String stbs) throws TransformerException {
		TransformerFactory tFactory = new TransformerFactoryImpl();

		Transformer transformer = tFactory.newTransformer(new StreamSource(getClass().getResourceAsStream("/cv24s.xslt")));

		StringWriter sw = new StringWriter();

		transformer.transform(new StreamSource(new StringReader(stbs)), new StreamResult(sw));

		return sw.toString();

	}





}