package com.shareknows.websitebackend.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shareknows.websitebackend.dao.ICountriesDao;
import com.shareknows.websitebackend.entity.Countries;
import com.shareknows.websitebackend.service.ICountriesService;

@Service
public class CountriesServiceImpl implements ICountriesService  {

	@Autowired
	private ICountriesDao countriesDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Countries> findAll() {
		return (List<Countries>) countriesDao.findAll();
	}

	@Override
	@Transactional
	public void save(Countries countries) {
		countriesDao.save(countries);		
	}

	@Override
	public Countries findByCountry(String country) {
		return (Countries) countriesDao.findByIdcountry(country);
	}
	
	@Override
	public Countries findCountry(Countries country) {
		return (Countries) countriesDao.findByIdcountry(country.getIdcountry());
	}

	@Override
	@Transactional
	public void deleteCountry(String country) {
		countriesDao.removeByIdcountry(country);		
	}

	@Override
	@Transactional
	public Countries updateCountry(Countries country) {
		return countriesDao.save(country);
	}

}
