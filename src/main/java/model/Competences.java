package model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(namespace = "http://univ.fr/cv24")
public class Competences {
    private List<Diplome> diplomes;
    private List<Certif> certifs;

    @XmlElement(name = "diplomes", namespace = "http://univ.fr/cv24")
    public List<Diplome> getDiplomes() {
        return diplomes;
    }

    public void setDiplomes(List<Diplome> diplomes) {
        this.diplomes = diplomes;
    }

    @XmlElement(name = "certifs", namespace = "http://univ.fr/cv24")
    public List<Certif> getCertifs() {
        return certifs;
    }

    public void setCertifs(List<Certif> certifs) {
        this.certifs = certifs;
    }
}
