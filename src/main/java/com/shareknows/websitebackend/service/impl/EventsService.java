package com.shareknows.websitebackend.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shareknows.websitebackend.entity.Events;
import com.shareknows.websitebackend.service.IEventsService;

//@Service
public class EventsService implements IEventsService {

	
	@Autowired
	private IEventsService eventsDao;
	
	@Override
	//@Transactional(readOnly=true)
	public List<Events> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Events events) {
		eventsDao.save(events);	
	}
	


}
