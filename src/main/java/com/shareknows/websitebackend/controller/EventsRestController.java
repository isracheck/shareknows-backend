package com.shareknows.websitebackend.controller;

import java.util.ArrayList;
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
import com.shareknows.websitebackend.model.MEvents;
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

	@GetMapping("/findByUsername/{username}")
	@ResponseStatus(HttpStatus.OK)
	public List<Events> findJoinersEvent(@PathVariable(value = "username") String username) {

		List<Events> eventsList = new ArrayList<>();

		User userDb = userService.findByUsername(username);
		if (userDb != null) {
			eventsList = eventsService.findByIduser(userDb.getIduser());
		}

		return eventsList;

	}

	@GetMapping("/findJoiners/{idevent}")
	public ResponseEntity<?> findJoinersEvent(@PathVariable(value = "idevent") Long idevent) {
		Events eventDb = eventsService.findByEvent(idevent);
		if (eventDb != null) {
			Collection<User> listaUsuarios = eventDb.getUsuarios();

			if (listaUsuarios != null) {
				return new ResponseEntity<>(listaUsuarios, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/save")
	public ResponseEntity<Void> saveEvent(@RequestBody MEvents events) {

		User userDb = userService.findByUsername(events.getUsername());

		if (userDb != null) {

			Events eventDb = new Events();

			eventDb.setTitle(events.getTitle());
			eventDb.setDescription(events.getDescription());
			eventDb.setPicture(events.getPicture());
			eventDb.setStartdate(events.getStartdate());
			eventDb.setEnddate(events.getEnddate());
			eventDb.setNumber(events.getNumber());
			eventDb.setEmail(events.getEmail());
			eventDb.setAddress(events.getAddress());
			eventDb.setIdcity(events.getIdcity());
			eventDb.setCreateAt(events.getCreateAt());
			eventDb.setIduser(userDb.getIduser());
			eventDb.setValue(events.getValue());
			eventDb.setPostalcode(events.getPostalcode());
			eventDb.setMaxPeople(events.getMaxPeople());
			eventDb.setIdlanguage(events.getIdlanguage());

			if (eventsService.findEvent(eventDb) == null) {
				eventsService.save(eventDb);
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			}
		}

		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/joinevent/{idevent}")
	public ResponseEntity<?> joinEvent(@PathVariable(value = "idevent") Long idevent, @RequestBody User user) {

		if (user != null) {
			User userDb = userService.findByUsername(user.getUsername());
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
	public ResponseEntity<?> updateEvent(@PathVariable(value = "idevent") Long idevent, @RequestBody MEvents events) {

		User userDb = userService.findByUsername(events.getUsername());

		if (userDb != null) {

			Events eventDb = null;
			eventDb = eventsService.findByEvent(idevent);
			if (eventDb != null) {

				eventDb.setIdevent(events.getIdevent());
				eventDb.setTitle(events.getTitle());
				eventDb.setDescription(events.getDescription());
				eventDb.setPicture(events.getPicture());
				eventDb.setStartdate(events.getStartdate());
				eventDb.setEnddate(events.getEnddate());
				eventDb.setNumber(events.getNumber());
				eventDb.setEmail(events.getEmail());
				eventDb.setAddress(events.getAddress());
				eventDb.setIdcity(events.getIdcity());
				eventDb.setCreateAt(events.getCreateAt());
				eventDb.setIduser(userDb.getIduser());
				eventDb.setValue(events.getValue());
				eventDb.setPostalcode(events.getPostalcode());
				eventDb.setMaxPeople(events.getMaxPeople());
				eventDb.setIdlanguage(events.getIdlanguage());

				eventsService.updateEvent(eventDb);
				return new ResponseEntity<>(eventDb, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/delete/{idevent}")
	public ResponseEntity<Void> deleteEvent(@PathVariable(value = "idevent") Long idevent) {
		eventsService.deleteEvent(idevent);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
