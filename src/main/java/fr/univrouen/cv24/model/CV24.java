package fr.univrouen.cv24.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.*;

@XmlRootElement(name="cv24", namespace = "http://univ.fr/cv24")
@XmlAccessorType(XmlAccessType.FIELD)
public class CV24 {

    @XmlElement(name="identite")
    private Identite identite;

    @XmlElement(name="objectif")
    private Objectif objectif;

    @XmlElement(name="prof")
    private Prof prof;

    @XmlElement(name="comptences")
    private Competences competences;

    @XmlElement(name="divers")
    private Divers divers;

    public Identite getIdentite() {
        return identite;
    }

    public void setIdentite(Identite value) {
        this.identite = value;
    }


    public Objectif getObjectif() {
        return objectif;
    }


    public void setObjectif(Objectif value) {
        this.objectif = value;
    }


    public Prof getProf() {
        return prof;
    }


    public void setProf(Prof value) {
        this.prof = value;
    }

    public Competences getCompetences() {
        return competences;
    }


    public void setCompetences(Competences value) {
        this.competences = value;
    }

    public Divers getDivers() {
        return divers;
    }

    public void setDivers(Divers value) {
        this.divers = value;
    }

}

