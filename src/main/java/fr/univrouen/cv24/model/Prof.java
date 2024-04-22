package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(namespace = "http://univ.fr/cv24")
public class Prof {
    private List<Detail> details;

    @XmlElement(name = "detail", namespace = "http://univ.fr/cv24")
    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public void setDetails(Detail detail) {
        this.details.add(detail);
    }
}
