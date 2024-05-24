package fr.univrouen.cv24.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "CV24")
public class CV24type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private IdentiteType identite;

    @OneToOne(cascade = CascadeType.ALL)
    private ObjectifType objectif;

    @OneToOne(cascade = CascadeType.ALL)
    private ProfType prof;

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
