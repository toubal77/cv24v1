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
import jakarta.xml.bind.annotation.XmlValue;

@Entity
@Table(name = "Objectif")
@XmlRootElement(name = "objectif")
@XmlType(propOrder={"statutObjectif", "objectifValue"})
@XmlAccessorType(XmlAccessType.FIELD)
public class ObjectifType {

    @Id
    @GeneratedValue
    @XmlTransient
    private Long id;

    //@XmlValue
    private String objectifValue;

    @XmlAttribute(name = "statut", required = true)
    private String statutObjectif;

    public String getObjectifValue() {
        return objectifValue;
    }

    public void setObjectifValue(String value) {
        this.objectifValue = value;
    }

    public String getstatutObjectif() {
        return statutObjectif;
    }

    public void setstatutObjectif(String value) {
        this.statutObjectif = value;
    }

    public Long getId() {
        return id;
    }
}
