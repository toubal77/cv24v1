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
@Table(name = "Prof")
@XmlRootElement(name = "prof")
@XmlType(propOrder={"detail"})
public class ProfType {


    @Id
    @GeneratedValue
    @XmlTransient
    private Long id;

    @XmlElement(required = true)
    @OneToMany(cascade = CascadeType.ALL)
    protected List<DetailType> detail;

    public List<DetailType> getDetail() {
        if (detail == null) {
            detail = new ArrayList<DetailType>();
        }
        return this.detail;
    }

    public Long getId() {
        return id;
    }
}