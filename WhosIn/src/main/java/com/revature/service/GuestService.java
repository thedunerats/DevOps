package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Event;
import com.revature.model.Guest;
import com.revature.model.User;
import com.revature.repository.GuestRepository;

@Service(value="guestService")
public class GuestService {
	private GuestRepository guestRepository;
	GuestService(){
		super();
	}
	
	public Guest findByEventAndUser(Event e, User u) {
		return guestRepository.findByEventAndUser(e, u);
	}
	
	public void insertAttendee(int eventid, int userid) {
		guestRepository.insertAttendee(eventid, userid);
	}
	
	public void removeAttendee(int eventid, int userid) {
		guestRepository.removeAttendee(eventid, userid);
	}
	
	@Autowired
	public void setGuestRepository(GuestRepository guestRepository) {
		this.guestRepository = guestRepository;
	}
}
