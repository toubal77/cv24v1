package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.*;

import java.util.List;
@XmlRootElement(name="competances" ,namespace = "http://univ.fr/cv24")
@XmlType(propOrder = {"diplome", "certif"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Competences {
    @XmlElement(name = "diplome", namespace = "http://univ.fr/cv24")
    private List<Diplome> diplome;
    @XmlElement(name = "certif", namespace = "http://univ.fr/cv24")
    private List<Certif> certif;

    public List<Diplome> getDiplomes() {
        return diplome;
    }

    public void setDiplomes(List<Diplome> diplomes) {
        this.diplome = diplomes;
    }

    public List<Certif> getCertifs() {
        return certif;
    }

    public void setCertifs(List<Certif> certifs) {
        this.certif = certifs;
    }
}
