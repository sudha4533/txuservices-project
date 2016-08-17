package com.txu.registration.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.txu.registration.model.ServicePlan;
import com.txu.registration.util.HibernateSessionManager;

@Repository
public class ServicePlanDAO {
	
    @SuppressWarnings("unchecked")
	public List<ServicePlan> getServicePlans() {
    	
        Session session = HibernateSessionManager.getSessionFactory().openSession();
		
    	Transaction trans = session.beginTransaction();
        Criteria criteria = session.createCriteria(ServicePlan.class);
        List<ServicePlan> serviceplans = criteria.list();
        trans.commit();
        session.close();
        return serviceplans;
        
    }
   
}