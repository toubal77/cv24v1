package fr.univrouen.cv24.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@Entity
@Table(name = "Prof")
@XmlRootElement(name = "prof")
@XmlType(propOrder={"detailProf"})
@XmlAccessorType(XmlAccessType.FIELD)
public class ProfType {


    @Id
    @GeneratedValue
    @XmlTransient
    private Long id;

    @XmlElement(required = true)
    @OneToMany(cascade = CascadeType.ALL)
    private List<DetailType> detailProf;

    public List<DetailType> getDetail() {
        if (detailProf == null) {
            detailProf = new ArrayList<DetailType>();
        }
        return this.detailProf;
    }

    public Long getId() {
        return id;
    }
}