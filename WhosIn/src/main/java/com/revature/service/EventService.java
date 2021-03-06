package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Event;
import com.revature.repository.EventRepository;

@Service(value="eventService")
public class EventService {
	private EventRepository eventRepository;
	
	public EventService() {
		super();
	}
	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	public List<Event> findAll() {
		return eventRepository.findAll();
	}
	
	public Event findById(int id) {
		return eventRepository.findById(id);
	}
	
	public Event findByEventname(String eventname) {
		return eventRepository.findByEventname(eventname);
	}
	
	public List<String> getEventGuests(int id) {
		return eventRepository.findEventGuests(id);
	}
	
	public List<String> getEventTags(int id) {
		return eventRepository.findEventTags(id);
	}
	
	public void save(Event e) {
		eventRepository.save(e);
	}
	
	public int getNumberOfGuests(int id) {
		return eventRepository.getNumberOfGuests(id);
	}
	
	@Autowired
	public void setEventRepository(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
}
