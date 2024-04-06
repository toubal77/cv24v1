package model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://univ.fr/cv24")
public class Date {
    private Date date;

    @XmlElement(name = "date", namespace = "http://univ.fr/cv24")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
