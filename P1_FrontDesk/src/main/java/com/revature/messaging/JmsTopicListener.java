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
import com.revature.dao.TicketDaoJDBCTemplate;
import com.revature.pojo.Ticket;

@Component
public class JmsTopicListener implements MessageListener {

	TicketDaoJDBCTemplate ticketDao;
	
	@Autowired	
	public void setTicketDao(TicketDaoJDBCTemplate ticketDao) {
		this.ticketDao = ticketDao;
	}
	
	@JmsListener(destination = AppConfig.ERROR_TOPIC, containerFactory = "jmsListenerContainerTopic")
	public void onMessage(Message message) {
		
		if (message instanceof TextMessage) {
			
			try {
			
				String msg = ((TextMessage) message).getText();
				System.out.println("Message Received From ERROR TOPIC");
				System.out.println(msg);
				
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
	
	@JmsListener(destination = AppConfig.RESOLVED_TOPIC, containerFactory = "jmsListenerContainerTopic")
	public void resolvedMessage(Message message) {
		
		if (message instanceof TextMessage) {
			
			try {
			
				String msg = ((TextMessage) message).getText();
				System.out.println("Message Received From RESOLVED TOPIC");
				System.out.println(msg);
				
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
