package fr.univrouen.cv24.util;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import fr.univrouen.cv24.model.TestCV;

import java.util.List;

@XmlRootElement(name="cv24s")
public class CV24ListWrapper {

    private List<TestCV> testCVs;

    @XmlElement(name = "cv24")
    public List<TestCV> getTestCVs() {
        return testCVs;
    }

    public void setTestCVs(List<TestCV> testCVs) {
        this.testCVs = testCVs;
    }
}