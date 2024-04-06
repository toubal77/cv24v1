package model;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "cv24", namespace = "http://univ.fr/cv24")
public class TestCV {
    @XmlElement(namespace = "http://univ.fr/cv24")
    private static final long serialVersionUID = 2024L;
    private static int compteur = 1;

    private Integer id;
    private Identite identite;
    private Objectif objectif;
    private List<Professionnel> professionnels;
    private Competences competences;
    private List<Divers> divers;

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

    @XmlElementWrapper(name = "professionnels", namespace = "http://univ.fr/cv24")
    @XmlElement(name = "professionnel")
    public List<Professionnel> getProfessionnels() {
        return professionnels;
    }

    public void setProfessionnels(List<Professionnel> professionnels) {
        this.professionnels = professionnels;
    }

    @XmlElement(name = "competences", namespace = "http://univ.fr/cv24")
    public Competences getCompetences() {
        return competences;
    }

    public void setCompetences(Competences competences) {
        this.competences = competences;
    }

    @XmlElementWrapper(name = "divers", namespace = "http://univ.fr/cv24")
    @XmlElement(name = "divers")
    public List<Divers> getDivers() {
        return divers;
    }

    public void setDivers(List<Divers> divers) {
        this.divers = divers;
    }

    public TestCV(Identite identite, Objectif objectif, List<Professionnel> professionnels, Competences competences, List<Divers> divers) {
        super();
        this.id = compteur++;
        this.identite = identite;
        this.objectif = objectif;
        this.professionnels = professionnels;
        this.competences = competences;
        this.divers = divers;
    }

    public TestCV() {
    }


}
