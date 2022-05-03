package com.shareknows.websitebackend.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shareknows.websitebackend.entity.Events;
import com.shareknows.websitebackend.entity.User;
import com.shareknows.websitebackend.service.IEventsService;
import com.shareknows.websitebackend.service.IUserService;

@RestController
@RequestMapping("/api/events")
public class EventsRestController {

	@Autowired
	private IEventsService eventsService;
	
	@Autowired
	private IUserService userService;

	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public List<Events> getEvents() {
		return eventsService.findAll();
	}

	@GetMapping("/find/{idevent}")
	public ResponseEntity<?> findEvent(@PathVariable(value = "idevent") Long idevent) {
		Events eventDb = eventsService.findByEvent(idevent);
		if (eventDb != null) {
			return new ResponseEntity<>(eventDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/findJoiners/{idevent}")
	public ResponseEntity<?> findJoinersEvent(@PathVariable(value = "idevent") Long idevent) {
		Events eventDb = eventsService.findByEvent(idevent);
		if (eventDb != null) {
			Collection<User> listaUsuarios = eventDb.getUsuarios();
			
			if(listaUsuarios !=null) {
				return new ResponseEntity<>(listaUsuarios, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/save")
	public ResponseEntity<Void> saveEvent(@RequestBody Events events) {

		if (eventsService.findEvent(events) == null) {
			eventsService.save(events);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

	}
	
	@PutMapping("/joinevent/{idevent}")
	public ResponseEntity<?> joinEvent(@PathVariable(value = "idevent") Long idevent,
			@RequestBody User user) {
		
		if (user != null){
			User userDb = userService.findByUser(user.getUser());
			Events eventDb = eventsService.findByEvent(idevent);
			
			if (userDb != null && eventDb != null) {
				eventDb.addUsuario(userDb);
				eventsService.save(eventDb);
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
			
	}

	@PutMapping("/update/{idevent}")
	public ResponseEntity<?> updateEvent(@PathVariable(value = "idevent") Long idevent,
			@RequestBody Events events) {
		Events eventDb = null;
		eventDb = eventsService.findByEvent(idevent);
		if (eventDb != null) {
			
			eventDb.setIdevent(events.getIdevent());
			eventDb.setDescription(events.getDescription());
			eventDb.setPicture(events.getPicture());
			eventDb.setStartdate(events.getStartdate());
			eventDb.setEnddate(events.getEnddate());
			eventDb.setNumber(events.getNumber());
			eventDb.setEmail(events.getEmail());
			eventDb.setAddress(events.getAddress());
			eventDb.setIdcity(events.getIdcity());
			eventDb.setCreateAt(events.getCreateAt());
			eventDb.setIduser(events.getIduser());
			eventDb.setValue(events.getValue());
			eventDb.setMaxPeople(events.getMaxPeople());
			eventDb.setIdlanguage(events.getIdlanguage());
			
	
			eventsService.updateEvent(events);
			return new ResponseEntity<>(eventDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{idevent}")
	public ResponseEntity<Void> deleteEvent(@PathVariable(value = "idevent") Long idevent) {
		eventsService.deleteEvent(idevent);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
