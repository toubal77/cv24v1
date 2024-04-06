package model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://univ.fr/cv24")
public class Institut {
    private String institut;

    @XmlElement(name = "institut", namespace = "http://univ.fr/cv24")
    public String getInstitut() {
        return institut;
    }

    public void setInstitut(String institut) {
        this.institut = institut;
    }
}
