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
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@Entity
@Table(name = "Competences")
@XmlRootElement(name = "competences")
@XmlType(propOrder={"diplome", "certif"})
@XmlAccessorType(XmlAccessType.FIELD)
public class CompetencesType {

    @Id
    @GeneratedValue
    @XmlTransient
    @Column(name="id")
    private Long id;

    @XmlElement(required = true)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_id_competences", referencedColumnName = "id")
    private List<DiplomeType> diplome;

    @XmlElement(required = true)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_id_competences", referencedColumnName = "id")
    private List<CertifType> certif;

    public List<DiplomeType> getDiplome() {
        if (diplome == null) {
            diplome = new ArrayList<DiplomeType>();
        }
        return this.diplome;
    }

    public List<CertifType> getCertif() {
        if (certif == null) {
            certif = new ArrayList<CertifType>();
        }
        return this.certif;
    }

    public void setCertif( List<CertifType> certifs) {
         this.certif = certifs;
    }

    public void setDIplomes( List<DiplomeType> diplomes) {
        this.diplome = diplomes;
   }

    public Long getId() {
        return id;
    }
}