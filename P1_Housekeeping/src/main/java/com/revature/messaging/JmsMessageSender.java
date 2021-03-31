package com.revature.messaging;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsMessageSender {

	private JmsTemplate jmsTemplate;
	
	private Queue managerQueue;

	@Autowired
	public void setManagerQueue(Queue managerQueue) {
		this.managerQueue = managerQueue;
	}

	@Autowired
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void managerSend(String msg) {
		jmsTemplate.send(managerQueue, (s) -> s.createTextMessage(msg));
	}
	
	
	
	
}
