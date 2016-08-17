package com.txu.registration.service.jms;

import com.txu.registration.dao.UpdateCustomerDAO;

/*
 * This class processes the messages and stores sid 
 * in respective customer table based on cid
 */
public class CustomerUpdateService {


	public void processMessage(int sid, int cid) {

		new UpdateCustomerDAO().saveSid(sid, cid);
	}

}
