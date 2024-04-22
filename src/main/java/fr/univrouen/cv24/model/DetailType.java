package fr.univrouen.cv24.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@Entity
@Table(name = "Detail")
@XmlRootElement(name = "detail")
@XmlType(propOrder={"prof", "titre", "datedeb", "datefin"}) 
@XmlAccessorType(XmlAccessType.FIELD)
public class DetailType {

    @Id
    @GeneratedValue
    @XmlTransient
    private Long id;
    
    @ManyToOne
    @XmlTransient
    private ProfType prof;

    @XmlElement(name="titre",required = true)
    @Column(name = "titre")
    private String titreDetail;

    @XmlElement(name="datedeb",required = true)
    @Column(name = "datedeb")
    private String datedebDetail;

    @Column(name = "datefin")
    @XmlElement(name="datefin",required = true)
    private String datefinDetail;

    public String getDatedebDetail() {
        return datedebDetail;
    }

    public void setDatedebDetail(String value) {
        this.datedebDetail = value;
    }

    public String getDatefinDetail() {
        return datefinDetail;
    }

    public void setDatefinDetail(String value) {
        this.datefinDetail = value;
    }

    public String getTitreDetail() {
        return titreDetail;
    }

    public void setTitreDetail(String value) {
        this.titreDetail = value;
    }

    public ProfType getProf() {
        return prof;
    }

    public void setProf(ProfType prof) {
        this.prof = prof;
    }

    public Long getId() {
        return id;
    }
}
