package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://univ.fr/cv24")
public class Lv {
    private String lang;
    private String cert;
    private String nivs;
    private String nivi;

    @XmlAttribute(name = "lang")
    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @XmlAttribute(name = "cert")
    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    @XmlAttribute(name = "nivs")
    public String getNivs() {
        return nivs;
    }

    public void setNivs(String nivs) {
        this.nivs = nivs;
    }

    @XmlAttribute(name = "nivi")
    public String getNivi() {
        return nivi;
    }

    public void setNivi(String nivi) {
        this.nivi = nivi;
    }
}
