package model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://univ.fr/cv24")
public class Certif {
    private String nom;
    private String date;

    @XmlElement(name = "titre", namespace = "http://univ.fr/cv24")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlElement(name = "datedeb", namespace = "http://univ.fr/cv24")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
