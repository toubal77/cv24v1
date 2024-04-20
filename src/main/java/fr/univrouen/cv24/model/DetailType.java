package fr.univrouen.cv24.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@Entity
@Table(name = "Detail")
@XmlRootElement(name = "detail")
@XmlType(propOrder={"titreDetail", "datedebDetail", "datefinDetail"}) 
@XmlAccessorType(XmlAccessType.FIELD)
public class DetailType {

    @Id
    @GeneratedValue
    @XmlTransient
    private Long id;
    
    @XmlElement(required = true)
    private String titreDetail;

    @XmlSchemaType(name = "date")
    @XmlElement(required = true)
    @Column(name = "datedeb")
    private LocalDate datedebDetail;

    @XmlSchemaType(name = "date")
    @Column(name = "datefin")
    private LocalDate datefinDetail;

    public LocalDate getDatedebDetail() {
        return datedebDetail;
    }

    public void setDatedebDetail(LocalDate value) {
        this.datedebDetail = value;
    }

    public LocalDate getDatefinDetail() {
        return datefinDetail;
    }

    public void setDatefinDetail(LocalDate value) {
        this.datefinDetail = value;
    }

    public String getTitreDetail() {
        return titreDetail;
    }

    public void setTitreDetail(String value) {
        this.titreDetail = value;
    }

    public Long getId() {
        return id;
    }
}
