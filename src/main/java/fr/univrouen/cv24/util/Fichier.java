package fr.univrouen.cv24.util;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Fichier {
	 public static String loadFileXML() {
	        Resource resource = new DefaultResourceLoader().getResource("smallCV.xml");
	        System.out.println("resource :" + resource);
	        StringBuilder content = new StringBuilder();

	        try (InputStream inputStream = resource.getInputStream();
	             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                content.append(line);
	            }
	        } catch (IOException e) {
	            return "Erreur lors de la lecture du fichier : " + e.getMessage();
	        }

	        return content.toString();
	    }
}
