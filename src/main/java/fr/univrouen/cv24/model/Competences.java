package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.*;

import java.util.List;
@XmlRootElement(name="competances" ,namespace = "http://univ.fr/cv24")
@XmlAccessorType(XmlAccessType.FIELD)
public class Competences {
    @XmlElement(name="diplome")
    private List<Diplome> diplomes;
    @XmlElement(name="certif")
    private List<Certif> certifs;

    public List<Diplome> getDiplomes() {
        return diplomes;
    }

    public void setDiplomes(List<Diplome> diplomes) {
        this.diplomes = diplomes;
    }

    public List<Certif> getCertifs() {
        return certifs;
    }

    public void setCertifs(List<Certif> certifs) {
        this.certifs = certifs;
    }
}
