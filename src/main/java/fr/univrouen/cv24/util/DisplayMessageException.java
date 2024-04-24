package fr.univrouen.cv24.util;

public class DisplayMessageException extends Exception {

    public DisplayMessageException(String message) {
        super(message);
    }
    
    public DisplayMessageException(){
        super("Erreur dans la validation XML par XSD (pas conforme)");
    }
}