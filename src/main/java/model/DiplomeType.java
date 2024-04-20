package model;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@Entity
@Table(name = "Diplome")
@XmlRootElement(name = "diplome")
@XmlType(propOrder={"titre", "date", "institut","niveau"})
public class DiplomeType {

    @Id
    @GeneratedValue
    @XmlTransient
    private Long id;

    @XmlSchemaType(name = "date")
    @XmlElement(required = true)
    @Column(name = "date")
    protected LocalDate date;

    protected String institut;

    @XmlElement(required = true)
    protected String titre;

    @XmlAttribute(name = "niveau", required = true)
    protected int niveau;



    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate value) {
        this.date = value;
    }


    public String getInstitut() {
        return institut;
    }

    public void setInstitut(String value) {
        this.institut = value;
    }

    public String getTitre() {
        return titre;
    }


    public void setTitre(String value) {
        this.titre = value;
    }


    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int value) {
        this.niveau = value;
    }

    public Long getId() {
        return id;
    }
}