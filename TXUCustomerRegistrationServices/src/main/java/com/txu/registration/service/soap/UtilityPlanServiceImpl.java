package com.txu.registration.service.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.txu.registration.dao.ServicePlanDAO;
import com.txu.registration.model.ServicePlan;

@WebService(endpointInterface="com.txu.registration.service.soap.UtilityPlanService", serviceName="UtilityPlanServiceImpl")
public class UtilityPlanServiceImpl implements UtilityPlanService {
	
    @WebMethod
    @Override
    public List<ServicePlan> getServicePlans() {
    	
    	List<ServicePlan> serviceplans = null;
    	
        serviceplans = new ServicePlanDAO().getServicePlans();
        
        return serviceplans;
        
    }
}