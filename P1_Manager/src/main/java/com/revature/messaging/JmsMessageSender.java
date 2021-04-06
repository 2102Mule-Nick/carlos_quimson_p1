package com.revature.messaging;

import java.io.Serializable;

import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.revature.pojo.Room;
import com.revature.pojo.Ticket;

@Service
public class JmsMessageSender {

	private JmsTemplate jmsTemplate;
	
	private Queue housekeepingQueue;
	
	private Topic housekeepingTicketTopic;
	
	@Autowired
	public void setHousekeepingTicketTopic(Topic housekeepingTicketTopic) {
		this.housekeepingTicketTopic = housekeepingTicketTopic;
	}

	@Autowired
	public void setManagerQueue(Queue housekeepingQueue) {
		this.housekeepingQueue = housekeepingQueue;
	}

	@Autowired
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void housekeepingSend(Room room) {
		jmsTemplate.send(housekeepingQueue, (s) -> s.createObjectMessage(room));
	}
	
	public void housekeepingTicketSend(Ticket ticket) {
		System.out.println("Housekeeping Ticket Topic: " + housekeepingTicketTopic);
		jmsTemplate.send(housekeepingTicketTopic, (s) -> s.createObjectMessage(ticket));
	}
	
	// for testing only
	public void simpleSend(String text) {
		jmsTemplate.send(housekeepingQueue, (s) -> s.createTextMessage(text));
	}
	
	
	
	
}
