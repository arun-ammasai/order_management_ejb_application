package com.ordermanagement.beans;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: OrderManagementListenerMDB
 */
@MessageDriven(name = "testMDB", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "connectionFactoryJndiName", propertyValue = "jms/orderMgmtConnectionFactory"),
		@ActivationConfigProperty(propertyName = "destinationjndiName", propertyValue = "jms/orderMgmtQueue")})
public class OrderManagementListenerMDB implements MessageListener {

	/**
	 * Default constructor.
	 */
	public OrderManagementListenerMDB() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {
		TextMessage msg = (TextMessage)message;
		try {
			System.out.println("Message has been received and the message content is :"+msg.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
