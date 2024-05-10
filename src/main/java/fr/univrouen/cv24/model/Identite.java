package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "http://univ.fr/cv24")
@XmlType(propOrder = {"genre", "nom", "prenom", "tel", "mel"})
public class Identite {
    private String genre;
    private String nom;
    private String prenom;
    private String tel;
    private String mel;
    
    @XmlElement(name = "genre", namespace = "http://univ.fr/cv24")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @XmlElement(name = "nom", namespace = "http://univ.fr/cv24")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlElement(name = "prenom", namespace = "http://univ.fr/cv24")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @XmlElement(name = "tel", namespace = "http://univ.fr/cv24")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @XmlElement(name = "mel", namespace = "http://univ.fr/cv24")
    public String getMel() {
        return mel;
    }

    public void setMel(String mel) {
        this.mel = mel;
    }
}
