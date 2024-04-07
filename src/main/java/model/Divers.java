package model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(namespace = "http://univ.fr/cv24")
public class Divers {
    private List<Lv> lv;
    private Autre autre;

    @XmlElement(name = "lv", namespace = "http://univ.fr/cv24")
    public List<Lv> getLv() {
        return lv;
    }

    public void setLv(List<Lv> lv) {
        this.lv = lv;
    }

    @XmlElement(name = "autre", namespace = "http://univ.fr/cv24")
    public Autre getAutre() {
        return autre;
    }

    public void setAutre(Autre autre) {
        this.autre = autre;
    }
}
