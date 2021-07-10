package com.ordermanagement;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class PostMessgaeToJMSQueue {
	
	public final String JMS_CONNECTION_FACTORY="jms/orderMgmtConnectionFactory";
	public final static String JMS_QUEUE_NAME="jms/orderMgmtQueue";
	public final String JMS_FACTORY="jms/orderMgmtQueue";

	
	private QueueConnectionFactory qconFactory;
	private QueueConnection qcon;
	private QueueSession qsession;
	private QueueSender qsender;
	private Queue queue;
	private TextMessage msg;
	
	public void init(Context context,String queueName) throws Exception{
		qconFactory = (QueueConnectionFactory) context.lookup(JMS_CONNECTION_FACTORY);
		qcon = qconFactory.createQueueConnection();
		qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		queue = (Queue) context.lookup(queueName);
		qsender = qsession.createSender(queue);
		msg = qsession.createTextMessage();
		qcon.start();
	}
	
	public void send(String message) throws Exception{
		msg.setText(message);
		qsender.send(msg);
	}
	
	public void close()throws Exception{
		qsender.close();
		qsession.close();
		qcon.close();
	}
	public static void main(String[] args) throws Exception{
		InitialContext context = EJBBeanHelper.getInitialContext();
		PostMessgaeToJMSQueue qs = new PostMessgaeToJMSQueue();
		qs.init(context, JMS_QUEUE_NAME);
		qs.send("Third Message to the queue");
		System.out.println("Message Posted");
	}
	
	
}
