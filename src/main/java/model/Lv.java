package model;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://univ.fr/cv24")
public class Lv {
    private String lang;
    private String cert;
    private String nivs;
    private String nivi;

    @XmlAttribute
    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @XmlAttribute
    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    @XmlAttribute
    public String getNivs() {
        return nivs;
    }

    public void setNivs(String nivs) {
        this.nivs = nivs;
    }

    @XmlAttribute
    public String getNivi() {
        return nivi;
    }

    public void setNivi(String nivi) {
        this.nivi = nivi;
    }
}
