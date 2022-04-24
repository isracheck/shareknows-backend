package com.shareknows.websitebackend.entity;

import java.io.Serializable;
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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iduser;
	
	@Column(length = 45, nullable = false, unique = true)
	private String user;

	@Column(length = 255, nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String name;
		
	private String lastname;

	private String phone;
	
	@Column(length = 100, unique = true, nullable = false)
	private String email;

	private String photo;
	
	@Column(name= "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "iduser", referencedColumnName = "iduser")
	private List<Events> eventsList = new ArrayList<>();
	
	@Column(length = 5, nullable = false)
	private String role = "USER";
	
	/*
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "iduserrel", referencedColumnName = "iduser")
	private List<UsersFollow> iduserRel = new ArrayList<>();
	*/
	
	public Long getIduser() {
		return iduser;
	}


	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public Date getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}


	public List<Events> getEventsList() {
		return eventsList;
	}


	public void setEventsList(List<Events> eventsList) {
		this.eventsList = eventsList;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
}
