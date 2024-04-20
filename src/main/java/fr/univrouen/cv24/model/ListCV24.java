package fr.univrouen.cv24.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "cv24s")
@XmlRootElement(name = "cv24")
public class ListCV24 {
    private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@XmlElement(name = "cv24",  required = true)
	@OneToMany(mappedBy="cv24s")
	private List<CV24type> cv24s; 
	 	
	public ListCV24() {
		this.cv24s = new ArrayList<>();
	}
	
	public Long getId() {
		return this.id;
	}
	
	@XmlTransient
	public  List<CV24type> getListcv24s() {
		return cv24s;
	}
	
	public void setListcv24s(List<CV24type> cv24s) {
		this.cv24s = cv24s;
	}
	
	@Override
	public String toString() {
		return ("cv24 [Id=" + id + ",cv24s=" + cv24s + "]");
	}
}