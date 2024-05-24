package fr.univrouen.cv24.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DisplayMessageException extends Exception {

    public DisplayMessageException(String message) {
        super(message);
    }
    
    public DisplayMessageException(){
        super("Erreur dans la validation XML par XSD (pas conforme)");
    }


public String loadHtmlTemplateErreur() {
    try {
        InputStream inputStream = getClass().getResourceAsStream("/erreurHtml.html");
        if (inputStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();
            return stringBuilder.toString();
        } else {
            System.err.println("Le fichier HTML n'a pas été trouvé.");
            return "";
        }
    } catch (IOException e) {
        e.printStackTrace();
        return "";
    }
}
}