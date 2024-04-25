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
	private List<TestCV> values;

	public CV24s() {}



	public CV24s(List<TestCV> values) {
		super();
		this.values = values;
	}



	public List<TestCV> getValues() {
		return values;
	}

	public void setValues(List<TestCV> values) {
		this.values = values;
	}


}