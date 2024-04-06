package model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "http://univ.fr/cv24")
@XmlType(propOrder = {"texte", "date", "institut"})
public class Diplome {
    private String texte;
    private String date;
    private String institut;

    @XmlElement(name = "texte", namespace = "http://univ.fr/cv24")
    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    @XmlElement(name = "date", namespace = "http://univ.fr/cv24")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @XmlElement(name = "institut", namespace = "http://univ.fr/cv24")
    public String getInstitut() {
        return institut;
    }

    public void setInstitut(String institut) {
        this.institut = institut;
    }
}
