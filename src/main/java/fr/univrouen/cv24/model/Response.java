package fr.univrouen.cv24.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="response")
@XmlAccessorType(XmlAccessType.FIELD)
public class Response {
	private Long id;
	private Type status;
	private String description;
	
	public Response() {}
	
	public Response(Long id, Type status) {
		this.id = id;
		this.status = status;
	}
	public Response(Long id, Type status, String message) {
		this.id = id;
		this.status = status;
		this.description = message;
	}
	
	public Response(Type status) {
		this.status = status;
	}
	
	
	public Response(Type status, String message) {
		this.status = status;
		this.description = message;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Type getStatus() {
		return status;
	}


	public void setStatus(Type status) {
		this.status = status;
	}



	public String getDescription() {
		return description;
	}


	public void setDescription(String message) {
		this.description = message;
	}



	public static enum Type{
		OK,
		DUPLICATED,
		INSERTED,
		DELETED,
		UPDATED,
		ERROR,
		NONE
	}
}
