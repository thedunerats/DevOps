package com.revature.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Event;
import com.revature.model.Guest;
import com.revature.model.GuestRequestModel;
import com.revature.model.User;
import com.revature.service.EventService;
import com.revature.service.GuestService;
import com.revature.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(value="/guest")
public class GuestController {
	private GuestService guestService;
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
	
	@Autowired
	public void setGuestService(GuestService guestService) {
		this.guestService = guestService;
	}
	/*
	 * GET method
	 * [URL]/event/findGuest
	 * 
	 * Return the guest within the specified event
	 */
	@GetMapping(value="/findGuest",produces=MediaType.APPLICATION_JSON_VALUE)
	public Guest findGuest(@RequestParam("eventid")int eventid, @RequestParam("userid")int userid) {
		Event e = eventService.findById(eventid);
		User u = userService.findById(userid);
		Guest g = guestService.findByEventAndUser(e, u);
		return g;
	}
	
	/*
	 * POST method
	 * [URL]/event/insertGuest
	 * 
	 * Inserts a guest into the database given the specified event and user ids
	 */
	@PostMapping(value="/insertGuest",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public boolean insertAttendee(@RequestBody GuestRequestModel grm) {
		if( grm.getEventid() > 0 &&  grm.getUserid() > 0) {
			try {
				guestService.insertAttendee(grm.getEventid(), grm.getUserid());
				return true;
			} catch(Exception noResultSet) { }
		}
		return false;
	}
	
	/*
	 * POST method
	 * [URL]/event/removeGuest
	 * 
	 * Deletes a guest from the database given the specified event and user ids
	 */
	@PostMapping(value="/removeGuest",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public boolean removeAttendee(@RequestBody GuestRequestModel grm) {
		if( grm.getEventid() > 0 &&  grm.getUserid() > 0) {
			try {
				guestService.removeAttendee(grm.getEventid(), grm.getUserid());
				return true;
			} catch(Exception noResultSet) { }
		}
		return false;
	}
}
