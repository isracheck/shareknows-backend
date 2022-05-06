package com.shareknows.websitebackend.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shareknows.websitebackend.dao.IEventsDao;
import com.shareknows.websitebackend.entity.Events;
import com.shareknows.websitebackend.service.IEventsService;

@Service
public class EventsService implements IEventsService {

	
	@Autowired
	private IEventsDao eventsDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Events> findAll() {
		return (List<Events>) eventsDao.findAll();
	}

	@Override
	public void save(Events events) {
		eventsDao.save(events);	
	}

	@Override
	public Events findByEvent(Long event) {
		return (Events) eventsDao.findByIdevent(event);
	}

	@Override
	public Events findEvent(Events event) {
		return (Events) eventsDao.findByIdevent(event.getIdevent());
	}

	@Override
	public void deleteEvent(Long event) {
		eventsDao.deleteById(event);
	}

	@Override
	public Events updateEvent(Events events) {
		return eventsDao.save(events);
	}

	@Override
	public List<Events> findByIduser(Long idUser) {
		return (List<Events>) eventsDao.findByIduser(idUser);
	}
	


}
