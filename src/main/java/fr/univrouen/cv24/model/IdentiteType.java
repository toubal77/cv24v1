package fr.univrouen.cv24.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@Entity
@Table(name = "Identite")
@XmlRootElement(name = "identite")
@XmlType(propOrder={"genre", "nom","prenom","tel","mel"})
@XmlAccessorType(XmlAccessType.FIELD)
public class IdentiteType {

    @Id
    @GeneratedValue
    @XmlTransient
    private Long id;

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    private GenreType genre;
    @XmlElement(required = true)
    private String nom;
    @XmlElement(required = true)
    private String prenom;
    private String tel;
    private String mel;

    public GenreType getGenre() {
        return genre;
    }


    public void setGenre(GenreType value) {
        this.genre = value;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String value) {
        this.nom = value;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String value) {
        this.prenom = value;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String value) {
        this.tel = value;
    }

    public String getMel() {
        return mel;
    }


    public void setMel(String value) {
        this.mel = value;
    }

    public Long getId() {
        return id;
    }
}