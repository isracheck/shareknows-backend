package com.shareknows.websitebackend.entity;

import java.io.Serializable;
import java.util.ArrayList;
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

//@Entity
//@Table(name = "usersfollow")
public class UsersFollow implements Serializable {

	private static final long serialVersionUID = 1L;

	// @Id
	// @Column(nullable = false)
	private Long iduser;

	private Long iduserrel;

	private String typefollow;

	public Long getIduser() {
		return iduser;
	}

	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}

	public Long getIduserrel() {
		return iduserrel;
	}

	public void setIduserrel(Long iduserrel) {
		this.iduserrel = iduserrel;
	}

	public String getTypefollow() {
		return typefollow;
	}

	public void setTypefollow(String typefollow) {
		this.typefollow = typefollow;
	}

}
