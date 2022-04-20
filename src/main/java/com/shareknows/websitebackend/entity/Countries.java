package com.shareknows.websitebackend.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Entity
//@Table(name = "countries")
public class Countries implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	//@Id
	//@Column(unique = true, length = 5, nullable = false)
	private String idcountry;
	
	//@Column(nullable = false)
	private String description;
	
	//@Column(nullable = false, name= "continentname", unique = true)
	private String continentName;
	
	//@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name = "idcountry", referencedColumnName = "idcountry")
	private List<Cities> citiesList = new ArrayList<>();

	public String getIdcountry() {
		return idcountry;
	}

	public void setIdcountry(String idcountry) {
		this.idcountry = idcountry;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}
	
	
}
