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
	public <S extends Event> S save(Event e);
	
	@Query(value="SELECT u.username "
			+ "FROM guest g "
			+ "INNER JOIN \"user\" u "
			+ "ON g.userid = u.userid "
			+ "WHERE g.eventid = :eventid",
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
}
