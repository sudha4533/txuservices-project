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

	public static Session getSession() {

		if (currentSession == null) {
			currentSession = sessionFactory.getCurrentSession();
		}
		return currentSession;
	}

	public static void closeSession() {
		// Close caches and connection pools
		if (currentSession != null) {
			currentSession.close();
			currentSession = null;
		}
	}

	/**
	 * Save/update entity.
	 * 
	 * @param entity
	 * Entity to save
	 */
	/*public static void save(Entity entity) {
		
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.evict(entity);
		session.saveOrUpdate(entity);
		tx.commit();
	}
*/
}
