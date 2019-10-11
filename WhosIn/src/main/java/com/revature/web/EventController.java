package com.revature.web;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Event;
import com.revature.model.EventRequestModel;
import com.revature.model.User;
import com.revature.service.EventService;
import com.revature.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(value="/event")
public class EventController {
	private EventService eventService;
	private UserService userService;
	
	@Autowired
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/*
	 * GET method
	 * [URL]/event/all
	 * Returns a list of all of the events in the database
	 */
	@GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Event> findAll() {
		return eventService.findAll();
	}
	
	/*
	 * GET method
	 * [URL]/event/{id}
	 * Returns an event specified by id
	 */
	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Event findById(@PathVariable int id) {
		return eventService.findById(id);
	}
	
	/*
	 * GET method
	 * [URL]/event/name/{eventname}
	 * 
	 * Returns an event specified by name
	 */
	@GetMapping(value="/name/{eventname}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Event findByEventname(@PathVariable String eventname) {
		return eventService.findByEventname(eventname);
	}
	
	/*
	 * GET method
	 * [URL]/event/{id}/guests
	 * 
	 * Returns the usernames of guests who are attending a specified event
	 */
	@GetMapping(value="/{id}/guests",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> getEventGuests(@PathVariable int id) {
		return eventService.getEventGuests(id);
	}
	
	/*
	 * GET method
	 * [URL]/event/{id}/tags
	 * 
	 * Returns all of the events associated with a specified tag
	 */
	@GetMapping(value="/{id}/tags",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> getEventTags(@PathVariable int id) {
		return eventService.getEventTags(id);
	}
	
	/*
	 * POST method
	 * [URL]/event/insert
	 * 
	 * Inserts a new event into the database
	 * Will not work if the provided start and end dates are not in the format
	 * 	"yyyy-MM-dd hh:mm:ss"
	 */
	@PostMapping(value="/insert",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Event insertEvent(@RequestBody EventRequestModel ereq) {
		System.out.println(ereq);
		Timestamp start = ereq.convertStringToTimestamp(ereq.getEventStartDate());
		Timestamp end = ereq.convertStringToTimestamp(ereq.getEventEndDate());
		User u = userService.findById(ereq.getEventOwner());
		Event e = new Event(
				ereq.getEventName(),
				ereq.getEventDescription(),
				start,	
				end,
				ereq.getLatitude(),
				ereq.getLongitude(),
				u);
		eventService.save(e);
		e = eventService.findByEventname(e.getEventname());
		return e;
	}
	
	/*
	 * GET method
	 * [URL]/event/{id}/numGuests
	 * 
	 * Returns the number of guests who will be attending a specified event
	 */
	@GetMapping(value="/{id}/numGuests",produces=MediaType.APPLICATION_JSON_VALUE)
	public int getNumberOfGuests(@PathVariable int id) {
		return eventService.getNumberOfGuests(id);
	}
}
