package com.shareknows.websitebackend.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "eventsuser")
public class Eventsuser implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long idevent;

	@Id
	private Long iduser;
}
