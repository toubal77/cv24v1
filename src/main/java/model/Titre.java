package model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://univ.fr/cv24")
public class Titre {
    private String value;

    @XmlElement(name = "titre", namespace = "http://univ.fr/cv24")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
