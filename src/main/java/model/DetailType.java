package model;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@Entity
@Table(name = "Detail")
@XmlRootElement(name = "detail")
@XmlType(propOrder={"titre", "datedeb", "datefin"})
public class DetailType {

    @Id
    @GeneratedValue
    @XmlTransient
    private Long id;
    @XmlElement(required = true)
    protected String titre;

    @XmlSchemaType(name = "date")
    @XmlElement(required = true)
    @Column(name = "datedeb")
    private LocalDate datedeb;

    @XmlSchemaType(name = "date")
    @Column(name = "datefin")
    private LocalDate datefin;



    public LocalDate getDatedeb() {
        return datedeb;
    }


    public void setDatedeb(LocalDate value) {
        this.datedeb = value;
    }


    public LocalDate getDatefin() {
        return datefin;
    }


    public void setDatefin(LocalDate value) {
        this.datefin = value;
    }


    public String getTitre() {
        return titre;
    }


    public void setTitre(String value) {
        this.titre = value;
    }

    public Long getId() {
        return id;
    }
}