package com.shareknows.websitebackend.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shareknows.websitebackend.entity.Cities;
import com.shareknows.websitebackend.entity.Events;

public interface IEventsDao extends CrudRepository<Events, Long>{
		
	public Integer removeByIdevent(Long idevent);

	public Events findByIdevent(Long idevent);
	
	public List<Events> findByIduser(Long iduser);

}
