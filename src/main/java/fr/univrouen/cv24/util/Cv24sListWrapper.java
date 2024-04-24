package fr.univrouen.cv24.util;



import fr.univrouen.cv24.model.TestCV;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "cv24List")
public class Cv24sListWrapper {
    private List<TestCV> cv24List;

    @XmlElement(name = "cv24")
    public List<TestCV> getCv24List() {
        return cv24List;
    }

    public void setCv24List(List<TestCV> cv24List) {
        this.cv24List = cv24List;
    }
}