package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import com.revature.model.Event;
import com.revature.model.User;
import com.revature.util.SessionFactory;

@Repository(value="userRepository")
public class UserRepositoryImpl implements UserRepository{

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		Session s = null;
		Transaction tx = null;
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			users = s.createQuery("FROM user", User.class).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return users;
	}

	@Override
	public User getUserById(int id) {
		User u = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			u = s.get(User.class, id);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return u;
	}

	@Override
	public void insertUser(User u) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			s.save(u);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
	}
	
	//find login ID for username and password
	public int verifyLogin(String eMail, String pass) {
		int userID = 0;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			NativeQuery<Integer> q = s.createNativeQuery("select userid from user where useremail = :user "
					+ "and userpassword = :pass",Integer.class); 
			q.setParameter("user",eMail);
			q.setParameter("pass",pass);
			userID = q.getSingleResult();
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return userID;

	}

}
