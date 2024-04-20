package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;

@Entity
@Table(name = "Objectif")
@XmlRootElement(name = "objectif")
@XmlType(propOrder={"status", "value"})
public class ObjectifType {

    @Id
    @GeneratedValue
    @XmlTransient
    private Long id;

    @XmlValue
    protected String value;
    @XmlAttribute(name = "statut", required = true)
    protected StatutType statut;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public StatutType getStatut() {
        return statut;
    }

    public void setStatut(StatutType value) {
        this.statut = value;
    }

    public Long getId() {
        return id;
    }
}