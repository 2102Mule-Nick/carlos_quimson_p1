package com.revature.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.revature.config.AppConfig;
import com.revature.dao.TicketDao;
import com.revature.pojo.Ticket;

@Component
public class JmsTopicListener implements MessageListener {
	
	TicketDao ticketDao;
	
	@Autowired	
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	@JmsListener(destination = AppConfig.ERROR_TOPIC, containerFactory = "jmsListenerContainerTopic")
	public void onMessage(Message message) {
		
		if (message instanceof TextMessage) {
			
			try {
			
				String msg = ((TextMessage) message).getText();
				System.out.println("Message Received From ERROR TOPIC");
				System.out.println(msg + "\n");
				
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
	
	@JmsListener(destination = AppConfig.RESOLVED_TOPIC, containerFactory = "jmsListenerContainerTopic")
	public void resolvedMessage(Message message) {
		System.out.println("Resolved Ticket received");
		if (message instanceof TextMessage) {
			
			try {
			
				String msg = ((TextMessage) message).getText();
				System.out.println("Message Received From RESOLVED TOPIC");
				System.out.println(msg + "\n");
				
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
	
	@JmsListener(destination = AppConfig.HOUSEKEEPING_TICKET_TOPIC, containerFactory = "jmsListenerContainerTopic")
	public void hkTicketMessage(Message message) {
		System.out.println("HK Ticket received");
		if (message instanceof ObjectMessage) {
			
			ObjectMessage om = (ObjectMessage)message;
			
			try {
				System.out.println("Housekeeping ticket topic: ");
				Ticket ticket = (Ticket)om.getObject();
							
				Ticket completeTicket = ticketDao.getTicketByNumber(ticket.getTicketNumber());
								
				System.out.println("New Ticket Received: ");
				System.out.println("Room Number: " + completeTicket.getRoomNumber());
				System.out.println("Request: " + completeTicket.getRequest() + "\n");
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
	
	@JmsListener(destination = AppConfig.MAINTENANCE_TICKET_TOPIC, containerFactory = "jmsListenerContainerTopic")
	public void maintenanceTicketdMessage(Message message) {
		System.out.println("Maintenance Ticket received");
		if (message instanceof ObjectMessage) {
			
			ObjectMessage om = (ObjectMessage)message;
			
			try {
				System.out.println("Maintenance ticket topic: ");
				Ticket ticket = (Ticket)om.getObject();
							
				Ticket completeTicket = ticketDao.getTicketByNumber(ticket.getTicketNumber());
								
				System.out.println("New Ticket Received: ");
				System.out.println("Room Number: " + completeTicket.getRoomNumber());
				System.out.println("Request: " + completeTicket.getRequest() + "\n");
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
