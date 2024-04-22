package fr.univrouen.cv24.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@Entity
@Table(name = "Diplome")
@XmlRootElement(name = "diplome")
@XmlType(propOrder={"titreDiplome", "diplomeDate", "institutDiplome","diplomeNiveau"})
@XmlAccessorType(XmlAccessType.FIELD)
public class DiplomeType {

    @Id
    @GeneratedValue
    @XmlTransient
    private Long id;

    @XmlSchemaType(name = "date")
    @XmlElement(required = true)
    @Column(name = "date")
    private String diplomeDate;

    @XmlElement(name="institut",required = true)
    private String institutDiplome;

    @XmlElement(name="titre",required = true)
    private String titreDiplome;    

    @XmlAttribute(name = "niveau", required = true)
    private String diplomeNiveau; 



    public String getDiplomeDate() {
        return diplomeDate;
    }


    public void setDiplomeDate(String value) {
        this.diplomeDate = value;
    }


    public String getInstitutDiplome() {
        return institutDiplome;
    }

    public void setInstitutDiplome(String value) {
        this.institutDiplome = value;
    }

    public String getTitreDiplome() {
        return titreDiplome;
    }


    public void setTitreDiplome(String value) {
        this.titreDiplome = value;
    }


    public String getDiplomeNiveau() {
        return diplomeNiveau;
    }

    public void setDiplomeNiveau(String value) {
        this.diplomeNiveau = value;
    }

    public Long getId() {
        return id;
    }
}
