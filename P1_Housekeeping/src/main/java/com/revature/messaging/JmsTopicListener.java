package com.revature.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.revature.config.AppConfig;
import com.revature.dao.TicketDaoJDBCTemplate;
import com.revature.pojo.Ticket;

@Component
public class JmsTopicListener implements MessageListener {

	TicketDaoJDBCTemplate ticketDao;
	
	@Autowired	
	public void setTicketDao(TicketDaoJDBCTemplate ticketDao) {
		this.ticketDao = ticketDao;
	}
	
	@JmsListener(destination = AppConfig.HOUSEKEEPING_TICKET_TOPIC, containerFactory = "jmsListenerContainerTopic")
	public void onMessage(Message message) {
		
		if (message instanceof ObjectMessage) {
			
			ObjectMessage om = (ObjectMessage)message;
			
			try {
				System.out.println("Housekeeping ticket topic: ");
				Ticket ticket = (Ticket)om.getObject();
							
				Ticket completeTicket = ticketDao.getTicketByNumber(ticket.getTicketNumber());
								
				System.out.println("New Ticket Received: ");
				System.out.println("Room Number: " + completeTicket.getRoomNumber());
				System.out.println("Request: " + completeTicket.getRequest());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
