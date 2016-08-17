package com.txu.registration.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.txu.registration.model.Customer;
import com.txu.registration.util.HibernateSessionManager;

public class CustomerServiceDAO {

	public Customer getCustomerDetailsById(int cust_id) {
		
	
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
	
		Query query = session.createQuery("from Customer where id = :cust_id ");
	    query.setParameter("cust_id", cust_id);
	    
	    Customer customer = (Customer) query.uniqueResult();
	    
	    tx.commit();
	    session.close();	
		
	    return customer;
		
	}
	
}
