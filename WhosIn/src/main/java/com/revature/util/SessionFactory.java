package com.revature.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionFactory {
	/*
	 * Just one SessionFactory will provide as many Sessions as necessary (it's a singleton)
	 */
	private static org.hibernate.SessionFactory sessionFactory;
	
	public static Session getSession() {
		if(sessionFactory == null) {
			sessionFactory = new Configuration()
					.configure().
					buildSessionFactory();
		}
		return sessionFactory.getCurrentSession();
	}
}