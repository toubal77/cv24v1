package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cv24", namespace = "http://univ.fr/cv24")
public class TestCV {
    
    private static final long serialVersionUID = 2024L;
    private static int compteur = 1;

    private Integer id;
    private Identite identite;
    private Objectif objectif;
    private Prof prof;
    private Competences competences;
    private Divers divers;

    @XmlElement(name = "identite", namespace = "http://univ.fr/cv24")
    public Identite getIdentite() {
        return identite;
    }

    public void setIdentite(Identite identite) {
        this.identite = identite;
    }

    @XmlElement(name = "objectif", namespace = "http://univ.fr/cv24")
    public Objectif getObjectif() {
        return objectif;
    }

    public void setObjectif(Objectif objectif) {
        this.objectif = objectif;
    }
    
    @XmlElement(name = "prof", namespace = "http://univ.fr/cv24")
    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof objectif) {
        this.prof = objectif;
    }

    @XmlElement(name = "competences", namespace = "http://univ.fr/cv24")
    public Competences getCompetences() {
        return competences;
    }

    public void setCompetences(Competences competences) {
        this.competences = competences;
    }

    @XmlElement(name = "divers", namespace = "http://univ.fr/cv24")
    public Divers getDivers() {
        return divers;
    }

    public void setDivers(Divers divers) {
        this.divers = divers;
    }


    public TestCV() {
    }

    public TestCV(List<TestCV> models) {

    }


}
