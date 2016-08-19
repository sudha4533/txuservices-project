package com.txu.registration.service.jms;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

public class MessageReceiver implements MessageListener {

	
	private static final Logger logger = Logger.getLogger(MessageReceiver.class);

	/**
	 * Receives to the jms message
	 */
	@Override
	public void onMessage(Message msg) {
		
		logger.info("Message Listener is active");

		TextMessage message = (TextMessage) msg;
		
		try {
			
			logger.info("Message recieved : " + message.getText());
			
			String[] msgAry = message.getText().split(":");

			int serviceId = Integer.parseInt(msgAry[0]);
			int customerId = Integer.parseInt(msgAry[1]);
			
			if (new CustomerUpdateService().processMessage(serviceId, customerId)) {
				logger.info("Service plan id is set to the customer");
			}
			else {
				logger.info("Service plan id update to the customer is unsuccessfull");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}