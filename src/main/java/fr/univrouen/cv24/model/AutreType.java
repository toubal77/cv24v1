package fr.univrouen.cv24.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "autreType")
@Entity
public class AutreType {

    @Id
    @GeneratedValue
    private Long id;

    @XmlAttribute(name = "titre", required = true)
    private String autreTitre;

    @XmlAttribute(name = "comment")
    private String autreComment;

    public String getAutreTitre() { 
        return autreTitre;
    }

    public void setAutreTitre(String value) {
        this.autreTitre = value;
    }

    public String getAutreComment() { 
        return autreComment;
    }

    public void setAutreComment(String value) { 
        this.autreComment = value;
    }

    public Long getId() {
        return id;
    }
}
