package com.txu.registration.service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.txu.registration.dao.CustomerServiceDAO;
import com.txu.registration.model.Customer;

@Service
@Path("/customerById")
@org.springframework.transaction.annotation.Transactional
public class CustomerServiceImpl {

	private Customer customer;
	
	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	@HeaderParam(value = "content-type = application/octet-stream")
	public Customer getCustomerDetailsById(@PathParam("param") int id) {
		
		customer = new CustomerServiceDAO().getCustomerDetailsById(id);

		return customer;
	}
}
