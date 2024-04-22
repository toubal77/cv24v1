package fr.univrouen.cv24.model;

import org.springframework.data.annotation.Reference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
    private String cert;

    @XmlAttribute(name = "nivs")
    private String nivs;

    @XmlAttribute(name = "nivi")
    private String nivi;

    @ManyToOne
    @JoinColumn(name = "divers_id")
    private DiversType divers;

    public String getLang() {
        return lang;
    }

    public void setLang(String value) {
        this.lang = value;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String value) {
        this.cert = value;
    }

    public String getNivs() {
        return nivs;
    }

    public void setNivs(String value) {
        this.nivs = value;
    }

    public String getNivi() {
        return nivi;
    }

    public void setNivi(String value) {
        this.nivi = value;
    }

    public Long getId() {
        return id;
    }

    public DiversType getDivers() {
        return divers;
    }

    public void setDivers(DiversType divers) {
        this.divers = divers;
    }
}
