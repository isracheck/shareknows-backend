package com.shareknows.websitebackend.service;

import java.util.List;


import com.shareknows.websitebackend.entity.Events;

public interface IEventsService {

	public List<Events> findAll();

	public void save(Events events);
	
	public Events findByEvent(Long event);
	
	Events findEvent(Events event);
	
	public void deleteEvent(Long event);
	
	public Events updateEvent(Events countries);
	
	public List<Events> findByIduser(Long idUser);

}
