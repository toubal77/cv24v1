package fr.univrouen.cv24.model;


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
@XmlType(name = "certif",propOrder={"titre", "datedeb", "datefin"})
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
    private String certifDatedeb; 

    @XmlSchemaType(name = "date")
    @XmlElement(required = true)
    @Column(name = "datefin")
    private String certifDatefin; 

    public String getCertifDatedeb() { 
        return certifDatedeb;
    }

    public void setCertifDatedeb(String value) { 
        this.certifDatedeb = value;
    }

    public String getCertifDatefin() { 
        return certifDatefin;
    }

    public void setCertifDatefin(String value) { 
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
