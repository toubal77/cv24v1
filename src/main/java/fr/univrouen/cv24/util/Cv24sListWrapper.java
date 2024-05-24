package fr.univrouen.cv24.util;



import fr.univrouen.cv24.model.CV24;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "cv24List")
public class Cv24sListWrapper {
    private List<CV24> cv24List;

    @XmlElement(name = "cv24")
    public List<CV24> getCv24List() {
        return cv24List;
    }

    public void setCv24List(List<CV24> cv24List) {
        this.cv24List = cv24List;
    }
}