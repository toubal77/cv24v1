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
@Table(name = "Certif")
@XmlRootElement(name = "certif")
@XmlType(name = "certif",propOrder={"certifTitre", "certifDatedeb", "certifDatefin"})
@XmlAccessorType(XmlAccessType.FIELD)
public class CertifType {

    @Id
    @GeneratedValue
    @XmlTransient
    private Long id;

    @XmlElement(required = true)
    private String certifTitre; 

    @XmlSchemaType(name = "date")
    @XmlElement(required = true)
    @Column(name = "datedeb")
    private LocalDate certifDatedeb; 

    @XmlSchemaType(name = "date")
    @XmlElement(required = true)
    @Column(name = "datefin")
    private LocalDate certifDatefin; 

    public LocalDate getCertifDatedeb() { 
        return certifDatedeb;
    }

    public void setCertifDatedeb(LocalDate value) { 
        this.certifDatedeb = value;
    }

    public LocalDate getCertifDatefin() { 
        return certifDatefin;
    }

    public void setCertifDatefin(LocalDate value) { 
        this.certifDatefin = value;
    }

    public String getCertifTitre() { 
        return certifTitre;
    }

    public void setCertifTitre(String value) { 
        this.certifTitre = value;
    }

    public Long getId() {
        return id;
    }
}
