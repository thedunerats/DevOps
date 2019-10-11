package com.revature.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.model.Event;

@Repository(value="eventRepository")
public interface EventRepository extends JpaRepository<Event, Integer>{
	public List<Event> findAll();
	public Event findById(int id);
	public Event findByEventname(String eventname);
	
	@Query(value="select u.username "
			+ "from guest g "
			+ "inner join \"user\" u "
			+ "on g.userid = u.userid "
			+ "where g.eventid = :eventid",
			nativeQuery = true)
	public List<String> findEventGuests(@Param("eventid") int id);
	
	@Query(value="select t.tagname from \"event\" e "
			+ "join eventtags et "
			+ "on e.eventid = et.eventid "
			+ "join tags t "
			+ "on et.tagid = t.tagid "
			+ "where e.eventid = :eventid",
			nativeQuery=true)
	public List<String> findEventTags(@Param("eventid") int id);
	
	@Query(value="select count(g.userid) " + 
			"from \"event\" e " + 
			"join guest g " + 
			"on e.eventid = g.eventid " + 
			"where e.eventid = :eventid",
			nativeQuery=true)
	public int getNumberOfGuests(@Param("eventid") int id);
}