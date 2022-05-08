package com.shareknows.websitebackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shareknows.websitebackend.dao.ICitiesDao;
import com.shareknows.websitebackend.entity.Cities;
import com.shareknows.websitebackend.service.ICitiesService;

@Service
public class CitiesServiceImpl implements ICitiesService {

	@Autowired
	private ICitiesDao citiesDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cities> findAll() {
		return (List<Cities>) citiesDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cities cities) {
		citiesDao.save(cities);
	}

	@Override
	public Cities findByCity(String city) {
		return (Cities) citiesDao.findByIdcity(city);
	}

	@Override
	public List<Cities> findByIdcountry(String idcountry) {
		return (List<Cities>) citiesDao.findByIdcountry(idcountry);
	}

	@Override
	public Cities findCity(Cities cities) {
		return (Cities) citiesDao.findByIdcity(cities.getIdcity());
	}

	@Override
	@Transactional
	public void deleteCity(String city) {
		citiesDao.removeByIdcity(city);

	}

	@Override
	@Transactional
	public Cities updateCity(Cities cities) {
		return citiesDao.save(cities);
	}

}
