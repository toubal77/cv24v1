package fr.univrouen.cv24.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

    @XmlElement(name="lv",required = true)
    @OneToMany(cascade = CascadeType.ALL)
    private List<LvType> languesDivers;

    @XmlElement(name="autre",required = true)
    @OneToOne(cascade = CascadeType.ALL)
    private AutreType autresDivers; 

    public List<LvType> getLanguesDivers() {
        if (languesDivers == null) {
            languesDivers = new ArrayList<LvType>();
        }
        return this.languesDivers;
    }


    public AutreType getAutresDivers() {
        return this.autresDivers;
    }

    public void setAutresDivers(AutreType autres) {
    
         this.autresDivers = autres;
    }

    public void setLanguesDivers(List<LvType> lv) {
    
        this.languesDivers = lv;
   }

    public Long getId() {
        return id;
    }
}
