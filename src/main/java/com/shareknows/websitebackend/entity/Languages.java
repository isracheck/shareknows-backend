package com.shareknows.websitebackend.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "language")
public class Languages implements Serializable  {

	private static final long serialVersionUID = 1L;

	//@Id
	//@Column(unique = true, length = 2, nullable = false)
	private String idlanguage;
	
	//@Column(nullable = false)
	private String description;

	public String getIdlanguage() {
		return idlanguage;
	}

	public void setIdlanguage(String idlanguage) {
		this.idlanguage = idlanguage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
