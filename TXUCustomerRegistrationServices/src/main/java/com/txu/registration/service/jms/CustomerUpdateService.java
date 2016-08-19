package com.txu.registration.service.jms;

import com.txu.registration.dao.UpdateCustomerDAO;

/**
 * This class processes the messages and stores sid 
 * in respective customer table based on cid.
 */
public class CustomerUpdateService {

	/**
	 * @param sid
	 * @param cid
	 * @returns true when service_id is attched to the customer
	 */
	public boolean processMessage(int sid, int cid) {

		int result = new UpdateCustomerDAO().saveServiceId(sid, cid);
		boolean bool = false;

		if (result > 0) {
			bool = true;
		}

		return bool;
	}

}
