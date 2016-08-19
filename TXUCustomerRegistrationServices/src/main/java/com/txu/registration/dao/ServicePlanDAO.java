package com.txu.registration.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.txu.registration.model.ServicePlan;
import com.txu.registration.util.HibernateSessionManager;


@Repository
public class ServicePlanDAO {
	
	/**
	 * @returns service plans.
	 */
    @SuppressWarnings("unchecked")
	public List<ServicePlan> getServicePlans() {
    	
        Session session = HibernateSessionManager.getSession();
		
    	Criteria criteria = session.createCriteria(ServicePlan.class);
        List<ServicePlan> serviceplans = criteria.list();
        HibernateSessionManager.closeSession();
	    
        return serviceplans;
        
    }
   
}