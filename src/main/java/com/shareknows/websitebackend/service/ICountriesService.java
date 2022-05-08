package com.shareknows.websitebackend.service;

import java.util.List;

import com.shareknows.websitebackend.entity.Countries;

public interface ICountriesService {

	public List<Countries> findAll();

	public void save(Countries countries);

	public Countries findByCountry(String country);

	Countries findCountry(Countries country);

	public void deleteCountry(String country);

	public Countries updateCountry(Countries countries);

}
