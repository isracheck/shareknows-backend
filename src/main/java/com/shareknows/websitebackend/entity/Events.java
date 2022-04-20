package com.shareknows.websitebackend.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
//@Table(name = "events")
public class Events implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idevent;
	
	//@Column(length = 45)
	private String description;
	
	//@Column(length = 45)
	private String picture;
	
	//@Column(nullable = false)
	private Timestamp startdate;
	
	//@Column(nullable = false)
	private Timestamp enddate;
	
	//@Column(length = 45)
	private String number;
	
	//@Column(length = 45)
	private String email;
	
	//@Column(length = 45, nullable = false)
	private String address;
	
	//@Column(name = "idcity")
	private String idcity;
	
	//@Column(name= "create_at", nullable = false)
	//@Temporal(TemporalType.DATE)
	private Date createAt;
	
	
	//@Column(name = "iduser")
	private Long iduser;
	
	
	//@Column(nullable = false)
	private BigDecimal value;
	
	//@Column(name= "maxpeople", nullable = false)
	private Integer maxPeople;

	public Long getIdevent() {
		return idevent;
	}

	public void setIdevent(Long idevent) {
		this.idevent = idevent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Timestamp getStartdate() {
		return startdate;
	}

	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}

	public Timestamp getEnddate() {
		return enddate;
	}

	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdcity() {
		return idcity;
	}

	public void setIdcity(String idcity) {
		this.idcity = idcity;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Long getIduser() {
		return iduser;
	}

	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Integer getMaxPeople() {
		return maxPeople;
	}

	public void setMaxPeople(Integer maxPeople) {
		this.maxPeople = maxPeople;
	}

}