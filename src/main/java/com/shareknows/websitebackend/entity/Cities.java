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
//@Table(name = "cities")
public class Cities implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	//@Id
	//@Column(unique = true, length = 5, nullable = false)
	private String idcity;
	
	//@Column(name = "idcountry", length = 5)
	private String idcountry;
	
	
	//@Column(nullable = false)
	private String name;
	
	//@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name = "idcity", referencedColumnName = "idcity")
	private List<Events> eventsList = new ArrayList<>();

	public String getIdcity() {
		return idcity;
	}

	public void setIdcity(String idcity) {
		this.idcity = idcity;
	}

	public String getIdcountry() {
		return idcountry;
	}

	public void setIdcountry(String idcountry) {
		this.idcountry = idcountry;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
