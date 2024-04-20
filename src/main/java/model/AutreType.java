package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;


@Entity
@Table(name = "Autre")
@XmlRootElement(name = "autre")
@XmlType(propOrder={"titre", "comment"})
public class AutreType {

    @Id
    @GeneratedValue
    @XmlTransient
    private Long id;

    @XmlAttribute(name = "titre", required = true)
    protected String titre;
    @XmlAttribute(name = "comment")
    protected String comment;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String value) {
        this.titre = value;
    }

    public String getComment() {
        return comment;
    }


    public void setComment(String value) {
        this.comment = value;
    }

    public Long getId() {
        return id;
    }
}