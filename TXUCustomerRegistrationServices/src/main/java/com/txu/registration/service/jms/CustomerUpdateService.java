package com.txu.registration.service.jms;

import com.txu.registration.dao.UpdateCustomerDAO;

/*
 * This class processes the messages and stores sid 
 * in respective customer table based on cid
 */
public class CustomerUpdateService {

	public boolean processMessage(int sid, int cid) {

		int result = new UpdateCustomerDAO().saveServiceId(sid, cid);
		boolean bool = false;

		if (result > 0) {
			bool = true;
		}

		return bool;
	}

}
