package com.shareknows.websitebackend.service;

import java.util.List;

import com.shareknows.websitebackend.entity.Cities;
import com.shareknows.websitebackend.entity.Countries;

public interface ICitiesService {

	public List<Cities> findAll();

	public void save(Cities cities);
	
	public Cities findByCity(String city);
	
	public List<Cities> findByIdcountry(String city);
	
	Cities findCity(Cities cities);
	
	public void deleteCity(String city);
	
	public Cities updateCity(Cities cities);
}
