package com.revature.messaging;

import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsMessageSender {

	private JmsTemplate jmsTemplate;
	
	private Topic errorTopic;
	
	private Topic resolvedTopic;
	
	@Autowired
	public void setResolvedTopic(Topic resolvedTopic) {
		this.resolvedTopic = resolvedTopic;
	}

	@Autowired
	public void setErrorTopic(Topic errorTopic) {
		this.errorTopic = errorTopic;
	}

	@Autowired
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void errorTopicSend(String msg) {
		jmsTemplate.send(errorTopic, (s) -> s.createTextMessage(msg));
	}
	
	public void resolvedTopicSend(String msg) {
		jmsTemplate.send(resolvedTopic, (s) -> s.createTextMessage(msg));
	}
	
}
