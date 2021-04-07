package com.revature.messaging;

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
	
	private Queue housekeepingTicketTopic;
	
	private Topic maintenanceTicketTopic;

	@Autowired
	public void setHousekeepingTicketTopic(Queue housekeepingTicketTopic) {
		this.housekeepingTicketTopic = housekeepingTicketTopic;
	}

	@Autowired
	public void setMaintenanceTicketTopic(Topic maintenanceTicketTopic) {
		this.maintenanceTicketTopic = maintenanceTicketTopic;
	}

	@Autowired
	public void setHousekeepingQueue(Queue housekeepingQueue) {
		this.housekeepingQueue = housekeepingQueue;
	}

	@Autowired
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void roomStatusSend(Room room) {
		jmsTemplate.send(housekeepingQueue, (s) -> s.createObjectMessage(room));
	}
	
	public void housekeepingTicketSend(Ticket ticket) {
		jmsTemplate.send(housekeepingTicketTopic, (s) -> s.createObjectMessage(ticket));
	}
	
	public void maintenanceTicketSend(Ticket ticket) {
		jmsTemplate.send(maintenanceTicketTopic, (s) -> s.createObjectMessage(ticket));
	}
	
}
