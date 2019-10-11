package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.model.Event;
import com.revature.model.Guest;
import com.revature.model.User;

@Repository(value="guestRepository")
public interface GuestRepository extends JpaRepository<Guest, Integer>{
	
	public Guest findByEventAndUser(Event e, User u);
	
	@Query(value="insert into guest values " + 
			"(default, :eventid, :userid)",
			nativeQuery=true)
	public void insertAttendee(@Param("eventid") int eventid, @Param("userid") int userid);
	
	@Query(value="delete from guest where " + 
			"eventid = :eventid and userid = :userid",
			nativeQuery=true)
	public void removeAttendee(@Param("eventid") int eventid, @Param("userid") int userid);
}
