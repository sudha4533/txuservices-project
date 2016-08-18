package com.txu.registration.service.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.txu.registration.model.ServicePlan;

@WebService
public interface UtilityPlanService {
	
    @WebMethod
    public List<ServicePlan> getServicePlans();
}