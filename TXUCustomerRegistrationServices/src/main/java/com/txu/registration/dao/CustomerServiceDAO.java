package com.txu.registration.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.txu.registration.model.Customer;
import com.txu.registration.util.HibernateSessionManager;

public class CustomerServiceDAO {

	/**
	 * @param cust_id
	 * @returns customer details by id
	 */
	public Customer getCustomerDetailsById(int cust_id) {
		
		Session session = HibernateSessionManager.getSession();
		
		Query query = session.createQuery("from Customer where id = :cust_id ");
	    query.setParameter("cust_id", cust_id);
	    
	    Customer customer = (Customer) query.uniqueResult();
	    HibernateSessionManager.closeSession();
	    return customer;
		
	}
	
}
