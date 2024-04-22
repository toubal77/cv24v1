package fr.univrouen.cv24.model;

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
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@Entity
@Table(name = "Prof")
@XmlRootElement(name = "prof")
@XmlType(propOrder={"detail"})
@XmlAccessorType(XmlAccessType.FIELD)
public class ProfType {

    @Id
    @GeneratedValue
    @XmlTransient
    private Long id;
    @XmlElementWrapper
    @XmlElement(name = "detail")
    @OneToMany(mappedBy = "prof", cascade = CascadeType.ALL)
    private List<DetailType> detail;

    public List<DetailType> getDetail() {
        return this.detail;
    }

    public void setDetail(List<DetailType> detail) {
       this.detail = detail;
    }

    public Long getId() {
        return id;
    }
}
