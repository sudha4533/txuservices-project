package com.txu.registration.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.txu.registration.util.HibernateSessionManager;

public class UpdateCustomerDAO {

	/**
	 * @param sid
	 * @param cid
	 * @returns 1 when service_id is updated for the customer
	 */
	public int saveServiceId(int sid, int cid) {

				
		Session session = HibernateSessionManager.getSession();
				
		Transaction tx = session.beginTransaction(); 
		Query query = session.createQuery("update Customer set service_id = :msid" + " where id = :mcid");
		
		query.setParameter("msid", sid);
		
		query.setParameter("mcid", cid);
		
		int result = query.executeUpdate();
		tx.commit();		
		HibernateSessionManager.closeSession();	    
		return result;
		
	}

}
