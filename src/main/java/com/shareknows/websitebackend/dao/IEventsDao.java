package com.shareknows.websitebackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shareknows.websitebackend.entity.Events;

public interface IEventsDao extends CrudRepository<Events, Long> {

	public Integer deleteByIdevent(Long idevent);

	public Events findByIdevent(Long idevent);

	public List<Events> findByIduser(Long iduser);

	@Modifying
	@Query("delete from Eventsuser where idevent = :idevent and iduser = :iduser")
	public Integer deleteEventUser(Long idevent, Long iduser);

}
