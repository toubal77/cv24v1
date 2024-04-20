package fr.univrouen.cv24.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@Entity
@Table(name = "CV24")
@XmlRootElement(name = "cv24", namespace = "http://univ.fr/cv24")
@XmlType(propOrder={"identite", "objectif", "prof", "competences", "divers"}) 
@XmlAccessorType(XmlAccessType.FIELD)
public class CV24type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlTransient
    private Long id;

    @XmlElement(required = true)
    @OneToOne(cascade = CascadeType.ALL)
    private IdentiteType identite;

    @XmlElement(required = true)
    @OneToOne(cascade = CascadeType.ALL)
    private ObjectifType objectif;

    @OneToOne(cascade = CascadeType.ALL)
    private ProfType prof;

    @XmlElement(required = true)
    @OneToOne(cascade = CascadeType.ALL)
    private CompetencesType competences;

    @OneToOne(cascade = CascadeType.ALL)
    private DiversType divers;

    public IdentiteType getIdentite() {
        return identite;
    }

    public void setIdentite(IdentiteType value) {
        this.identite = value;
    }


    public ObjectifType getObjectif() {
        return objectif;
    }


    public void setObjectif(ObjectifType value) {
        this.objectif = value;
    }


    public ProfType getProf() {
        return prof;
    }


    public void setProf(ProfType value) {
        this.prof = value;
    }

    public CompetencesType getCompetences() {
        return competences;
    }


    public void setCompetences(CompetencesType value) {
        this.competences = value;
    }

    public DiversType getDivers() {
        return divers;
    }

    public void setDivers(DiversType value) {
        this.divers = value;
    }

    public Long getId() {
        return id;
    }
}
