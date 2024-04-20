package model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.xml.bind.annotation.XmlAttribute;

import jakarta.xml.bind.annotation.XmlTransient;

public class LvType {

    @Id
    @GeneratedValue
    @XmlTransient
    private Long id;

    @XmlAttribute(name = "lang", required = true)
    protected String lang;
    @XmlAttribute(name = "cert", required = true)
    protected CrtType cert;
    @XmlAttribute(name = "nivs")
    protected NivsType nivs;
    @XmlAttribute(name = "nivi")
    protected Integer nivi;

    public String getLang() {
        return lang;
    }

    public void setLang(String value) {
        this.lang = value;
    }


    public CrtType getCert() {
        return cert;
    }


    public void setCert(CrtType value) {
        this.cert = value;
    }

    public NivsType getNivs() {
        return nivs;
    }

    public void setNivs(NivsType value) {
        this.nivs = value;
    }


    public Integer getNivi() {
        return nivi;
    }


    public void setNivi(Integer value) {
        this.nivi = value;
    }

    public Long getId() {
        return id;
    }
}