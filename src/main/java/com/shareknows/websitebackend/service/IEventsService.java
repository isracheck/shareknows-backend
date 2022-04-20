package com.shareknows.websitebackend.service;

import java.util.List;

import com.shareknows.websitebackend.entity.Events;

public interface IEventsService {

	public List<Events> findAll();

	public void save(Events events);

}
