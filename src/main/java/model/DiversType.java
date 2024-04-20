package model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@Entity
@Table(name = "Divers")
@XmlRootElement(name = "divers")
@XmlType(propOrder={"lv", "autre"})
public class DiversType {

    @Id
    @GeneratedValue
    @XmlTransient
    private Long id;

    @XmlElement(required = true)
    @OneToMany(cascade = CascadeType.ALL)
    protected List<LvType> lv;

    @OneToMany(cascade = CascadeType.ALL)
    protected List<AutreType> autre;

    public List<LvType> getLv() {
        if (lv == null) {
            lv = new ArrayList<LvType>();
        }
        return this.lv;
    }


    public List<AutreType> getAutre() {
        if (autre == null) {
            autre = new ArrayList<AutreType>();
        }
        return this.autre;
    }

    public Long getId() {
        return id;
    }
}