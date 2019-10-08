package com.revature.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Event;
import com.revature.service.EventService;

@CrossOrigin
@RestController
@RequestMapping(value="/event")
public class EventController {
	private EventService eventService;
	
	@Autowired
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}
	
	@GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Event> findAll() {
		return eventService.findAll();
	}
	
	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Event findById(@PathVariable int id) {
		return eventService.findById(id);
	}
	
	@GetMapping(value="/name/{eventname}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Event findByEventname(@PathVariable String eventname) {
		return eventService.findByEventname(eventname);
	}
	
	@GetMapping(value="/{id}/guests",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> getEventGuests(@PathVariable int id) {
		return eventService.getEventGuests(id);
	}
	
	@GetMapping(value="/{id}/tags",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> getEventTags(@PathVariable int id) {
		return eventService.getEventTags(id);
	}
}
