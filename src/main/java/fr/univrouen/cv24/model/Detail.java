package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://univ.fr/cv24")
public class Detail {
    private String datedeb;
    private String datefin;
    private String titre;

    @XmlElement(name = "datedeb", namespace = "http://univ.fr/cv24")
    public String getDatedeb() {
        return datedeb;
    }

    public void setDatedeb(String datedeb) {
        this.datedeb = datedeb;
    }

    @XmlElement(name = "datefin", namespace = "http://univ.fr/cv24")
    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    @XmlElement(name = "titre", namespace = "http://univ.fr/cv24")
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
