package com.revature.messaging;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsMessageSender {

	private JmsTemplate jmsTemplate;
	
	private Queue housekeepingQueue;

	@Autowired
	public void setManagerQueue(Queue housekeepingQueue) {
		this.housekeepingQueue = housekeepingQueue;
	}

	@Autowired
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void housekeepingSend(String msg) {
		jmsTemplate.send(housekeepingQueue, (s) -> s.createTextMessage(msg));
	}
	
	
	
	
}
