package model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@Entity
@Table(name = "CV24")
@XmlRootElement(name = "cv24")
@XmlType(propOrder={"identite", "objectif", "prof", "competences", "divers", "identite"})
public class CV24type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlTransient
    private Long id;

    @XmlElement(required = true)
    @OneToOne(cascade = CascadeType.ALL)
    protected Identite identite;

    @XmlElement(required = true)
    @OneToOne(cascade = CascadeType.ALL)
    protected Objectif objectif;

    @OneToOne(cascade = CascadeType.ALL)
    protected Prof prof;

    @XmlElement(required = true)
    @OneToOne(cascade = CascadeType.ALL)
    protected Competences competences;

    @OneToOne(cascade = CascadeType.ALL)
    protected Divers divers;

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

    public Long getId() {
        return id;
    }
}

