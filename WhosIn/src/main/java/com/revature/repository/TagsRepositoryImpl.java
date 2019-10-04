package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.revature.model.Event;
import com.revature.model.Tags;
import com.revature.model.User;
import com.revature.util.SessionFactory;

public class TagsRepositoryImpl implements TagsRepository {

	@Override
	public List<Tags> getAllTags() {
		List<Tags> tags = new ArrayList<Tags>();
		Session s = null;
		Transaction tx = null;
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			tags = s.createQuery("FROM user", Tags.class).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return tags;
	}

	@Override
	public Tags getTagById(int id) {
		Tags t = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			t = s.get(Tags.class, id);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return t;
	}

	@Override
	public void insertTag(Tags t) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			s.save(t);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
	}
	
	public void deleteTag(Tags t) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			s.delete(t);
			tx.commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
	}
	
	//search for events based on an input character pattern
	public List<Tags> searchForTags(String str) {
		List<Tags> tags = new ArrayList<Tags>();
		Session s = null;
		Transaction tx = null;
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			NativeQuery<Tags> q = s.createNativeQuery("select * from tags where tagname like ':in%'",Tags.class); 
			q.setParameter("in",str);
			tags = q.getResultList();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return tags;
	}

}
