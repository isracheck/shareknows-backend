package com.shareknows.websitebackend.service;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shareknows.websitebackend.entity.Cities;


//@Service
public class CitiesService implements ICitiesService {
	
	@Autowired
	private ICitiesService citiesDao;

	@Override
	//@Transactional(readOnly=true)
	public List<Cities> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
