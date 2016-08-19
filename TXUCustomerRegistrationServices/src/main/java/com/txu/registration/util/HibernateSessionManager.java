package com.txu.registration.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionManager {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static Session currentSession;

	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * @returns a session
	 */
	public static Session getSession() {

		if (currentSession == null) {
			currentSession = sessionFactory.openSession();
		}
		return currentSession;
	}

	/**
	 * Close caches and connection pools
	 */
	public static void closeSession() {
		 
		if (currentSession != null) {
			currentSession.close();
			currentSession = null;
		}
	}
}
