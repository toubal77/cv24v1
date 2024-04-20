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
@Table(name = "Divers")
@XmlRootElement(name = "divers")
@XmlType(propOrder={"languesDivers", "autresDivers"})
@XmlAccessorType(XmlAccessType.FIELD)
public class DiversType {

    @Id
    @GeneratedValue
    @XmlTransient
    private Long id;

    @XmlElement(required = true)
    @OneToMany(cascade = CascadeType.ALL)
    private List<LvType> languesDivers;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AutreType> autresDivers; 

    public List<LvType> getLanguesDivers() {
        if (languesDivers == null) {
            languesDivers = new ArrayList<LvType>();
        }
        return this.languesDivers;
    }


    public List<AutreType> getAutresDivers() {
        if (autresDivers == null) {
            autresDivers = new ArrayList<AutreType>();
        }
        return this.autresDivers;
    }

    public Long getId() {
        return id;
    }
}
