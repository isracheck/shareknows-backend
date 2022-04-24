package com.shareknows.websitebackend.dao;

import org.springframework.data.repository.CrudRepository;

import com.shareknows.websitebackend.entity.Cities;

public interface ICitiesDao extends CrudRepository<Cities, String>{
		
	public Integer removeByIdcity(String idcity);

	public Cities findByIdcity(String idcity);

}
