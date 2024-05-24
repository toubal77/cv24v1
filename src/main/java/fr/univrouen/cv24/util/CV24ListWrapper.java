package fr.univrouen.cv24.util;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import fr.univrouen.cv24.model.CV24;

import java.util.List;

@XmlRootElement(name="cv24s")
public class CV24ListWrapper {

    private List<CV24> CV24s;

    @XmlElement(name = "cv24")
    public List<CV24> getCV24s() {
        return CV24s;
    }

    public void setCV24s(List<CV24> CV24s) {
        this.CV24s = CV24s;
    }
}