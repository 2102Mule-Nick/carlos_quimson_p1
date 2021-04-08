package com.revature.messaging;

import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsMessageSender {

	private JmsTemplate jmsTemplate;
	
	private Queue housekeepingQueue;
	
	private Topic errorTopic;
	
	private Topic resolvedTopic;
	
	@Autowired
	@Qualifier("resolvedTopic")
	public void setResolvedTopic(Topic resolvedTopic) {
		this.resolvedTopic = resolvedTopic;
	}

	@Autowired
	@Qualifier("errorTopic")
	public void setErrorTopic(Topic errorTopic) {
		this.errorTopic = errorTopic;
	}

	@Autowired
	@Qualifier("roomStatusQueue")
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

	
	public void errorTopicSend(String msg) {
		jmsTemplate.send(errorTopic, (s) -> s.createTextMessage(msg));
	}
	
	public void resolvedTopicSend(String msg) {
		jmsTemplate.send(resolvedTopic, (s) -> s.createTextMessage(msg));
	}
	
}
