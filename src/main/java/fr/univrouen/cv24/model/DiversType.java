package fr.univrouen.cv24.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@XmlType(propOrder={"lv", "autre"})
@XmlAccessorType(XmlAccessType.FIELD)
public class DiversType {

    @Id
    @GeneratedValue
    @XmlTransient
    @Column(name="id")
    private Long id;

    @XmlElement(required = true)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_id_divers", referencedColumnName = "id")
    protected List<LvType> lv;

    @XmlElement(name="autre",required = true)
    @OneToOne(cascade = CascadeType.ALL)
    private AutreType autre; 

    public List<LvType> getLanguesDivers() {
        if (lv == null) {
            lv = new ArrayList<LvType>();
        }
        return this.lv;
    }


    public AutreType getAutresDivers() {
        return this.autre;
    }

    public void setAutresDivers(AutreType autres) {
    
         this.autre = autres;
    }

    public void setLanguesDivers(List<LvType> lv) {
    
        this.lv = lv;
   }

    public Long getId() {
        return id;
    }
}
