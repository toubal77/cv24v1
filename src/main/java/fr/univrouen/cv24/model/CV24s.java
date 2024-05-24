package fr.univrouen.cv24.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="cv24s")
@XmlAccessorType(XmlAccessType.FIELD)
public class CV24s {

	@XmlElement(name="cv24")
	private List<CV24> values;

	public CV24s() {}



	public CV24s(List<CV24> values) {
		super();
		this.values = values;
	}



	public List<CV24> getValues() {
		return values;
	}

	public void setValues(List<CV24> values) {
		this.values = values;
	}


}