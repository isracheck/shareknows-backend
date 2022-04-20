package com.shareknows.websitebackend.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shareknows.websitebackend.entity.Countries;

//@Service
public class CountriesService implements ICountriesService  {

	@Autowired
	private ICountriesService countriesDao;
	
	@Override
	//@Transactional(readOnly=true)
	public List<Countries> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
