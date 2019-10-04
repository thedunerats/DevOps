package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.revature.model.Event;
import com.revature.util.SessionFactory;

public class EventRepositoryImpl implements EventRepository {

	@Override
	public List<Event> getAllEvents() {
		List<Event> events = new ArrayList<Event>();
		Session s = null;
		Transaction tx = null;
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			events = s.createQuery("FROM user", Event.class).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return events;
	}

	@Override
	public Event getEventById(int id) {
		Event e = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			e = s.get(Event.class, id);
			tx.commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return e;
	}

	@Override
	public void insertEvent(Event e) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			s.save(e);
			tx.commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
	}
	
	public void deleteEvent(Event e) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			s.delete(e);
			tx.commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
	}
	
	//search for events based on an input character pattern
	public List<Event> searchForEvents(String str) {
		List<Event> events = new ArrayList<Event>();
		Session s = null;
		Transaction tx = null;
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			NativeQuery<Event> q = s.createNativeQuery("select * from event where eventname like ':in%'",Event.class); 
			q.setParameter("in",str);
			events = q.getResultList();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return events;
	}

}
