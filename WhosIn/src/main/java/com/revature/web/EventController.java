package com.revature.web;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping(value="/insert",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Event insertEvent(EventRequestModel ereq) {
		Timestamp start = ereq.convertStringToTimestamp(ereq.getEventstartdate());
		Timestamp end = ereq.convertStringToTimestamp(ereq.getEventenddate());
		User u = userService.findById(ereq.getEventownerid());
		Event e = new Event(
				ereq.getId(),
				ereq.getEventname(),
				ereq.getEventdescription(),
				start,
				end,
				ereq.getLatitude(),
				ereq.getLongitude(),
				u);
		eventService.save(e);
		e = eventService.findByEventname(e.getEventname());
		return e;
	}
	
	@GetMapping(value="/{id}/numGuests",produces=MediaType.APPLICATION_JSON_VALUE)
	public int getNumberOfGuests(@PathVariable int id) {
		return eventService.getNumberOfGuests(id);
	}
	
	@GetMapping(value="/insertGuest")
	public boolean insertAttendee(@RequestParam("eventid") int eventid, @RequestParam("userid") int userid) {
		if( eventid > 0 &&  userid > 0) {
			try {
			eventService.insertAttendee(eventid, userid);
			return true;
			} catch(Exception noResultSet) { }
		}
		return false;
	}
	
	@GetMapping(value="/removeGuest")
	public boolean removeAttendee(@RequestParam("eventid") int eventid, @RequestParam("userid") int userid) {
		if(eventid > 0 && userid > 0) {
			try {
				eventService.removeAttendee(eventid, userid);
				return true;
			} catch (Exception noResultSet) { }
		}
		return false;
	}
}
