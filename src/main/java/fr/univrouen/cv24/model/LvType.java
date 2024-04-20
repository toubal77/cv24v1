package fr.univrouen.cv24.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@Entity
@Table(name = "Lv")
@XmlRootElement(name = "lv")
@XmlType(propOrder={"lang", "cert", "nivs","nivi"})
@XmlAccessorType(XmlAccessType.FIELD)
public class LvType {

    @Id
    @GeneratedValue
    @XmlTransient
    private Long id;

    @XmlAttribute(name = "lang", required = true)
    private String lang;
    @XmlAttribute(name = "cert", required = true)
    private CrtType cert;
    @XmlAttribute(name = "nivs")
    private NivsType nivs;
    @XmlAttribute(name = "nivi")
    private Integer nivi;

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