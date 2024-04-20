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
@Table(name = "Competences")
@XmlRootElement(name = "competences")
@XmlType(propOrder={"diplome", "certif"})
public class CompetencesType<DiplomeType> {

    @Id
    @GeneratedValue
    @XmlTransient
    private Long id;

    @XmlElement(required = true)
    @OneToMany(cascade = CascadeType.ALL)
    protected List<DiplomeType> diplome;

    @OneToMany(cascade = CascadeType.ALL)
    protected List<CertifType> certif;

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

    public Long getId() {
        return id;
    }
}