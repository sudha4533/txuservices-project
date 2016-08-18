package com.txu.registration.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.txu.registration.util.HibernateSessionManager;

public class UpdateCustomerDAO {

	
	public int saveServiceId(int sid, int cid) {

				
		Session session = HibernateSessionManager.getSession();
				
		
		Query query = session.createQuery("update Customer set service_id = :msid" + " where id = :mcid");
		
		query.setParameter("msid", sid);
		
		query.setParameter("mcid", cid);
		
		int result = query.executeUpdate();
			
		HibernateSessionManager.closeSession();	
		return result;
		
	}

}
