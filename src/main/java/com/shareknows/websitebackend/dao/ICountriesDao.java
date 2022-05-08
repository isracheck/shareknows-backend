package com.shareknows.websitebackend.dao;

import org.springframework.data.repository.CrudRepository;

import com.shareknows.websitebackend.entity.Countries;

public interface ICountriesDao extends CrudRepository<Countries, String> {

	public Integer removeByIdcountry(String idcountry);

	public Countries findByIdcountry(String idcountry);

}
