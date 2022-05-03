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

@Entity
@Table(name = "language")
public class Languages implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, length = 2, nullable = false)
	private String idlanguage;
	
	@Column(nullable = false)
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idlanguage", referencedColumnName = "idlanguage")
	private List<Events> eventsList = new ArrayList<>();

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

	public List<Events> getEventsList() {
		return eventsList;
	}

	public void setEventsList(List<Events> eventsList) {
		this.eventsList = eventsList;
	}

}
