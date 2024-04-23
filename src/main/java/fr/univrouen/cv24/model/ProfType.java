package fr.univrouen.cv24.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@XmlType(propOrder={"detail"})
@XmlAccessorType(XmlAccessType.FIELD)
public class ProfType {

    @Id
    @GeneratedValue
    @XmlTransient
     @Column(name="id")
    private Long id;
    @XmlElement(required = true)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_id_prof", referencedColumnName = "id")
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
