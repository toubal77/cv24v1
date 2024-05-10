package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "http://univ.fr/cv24")
@XmlType(propOrder = {"titre", "date", "institut"})
public class Diplome {
    private String titre;
    private String date;
    private String institut;
    private String niveau;

    @XmlAttribute(name="niveau")
    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String value) {
        this.niveau = value;
    }

    @XmlElement(name = "titre", namespace = "http://univ.fr/cv24")
    public String gettitre() {
        return titre;
    }

    public void settitre(String titre) {
        this.titre = titre;
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
