package com.revature.messaging;

import java.sql.SQLException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.revature.config.AppConfig;
import com.revature.dao.RoomDao;
import com.revature.dao.RoomDaoJdbcTemplate;
import com.revature.dao.TicketDaoJDBCTemplate;
import com.revature.pojo.Room;
import com.revature.pojo.Ticket;
import com.revature.service.HousekeepingService;

@Component
public class JmsMessageListener implements MessageListener{

	HousekeepingService service;
	
	@Autowired
	public void setService(HousekeepingService service) {
		this.service = service;
	}


	@JmsListener(destination = AppConfig.ROOM_STATUS_QUEUE, containerFactory = "jmsListenerContainerQueue")
	@Qualifier("roomStatusQueue")
	public void onMessage(Message message) {
		
		if (message instanceof ObjectMessage) {
			
			ObjectMessage om = (ObjectMessage)message;
			
			try {
				//add service here
				Room room = (Room)om.getObject();
				service.updateRoomStatus(room);
				//System.out.println("Message Received: Updating room " + room.getRoomNumber());

			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
		else if (message instanceof TextMessage) {
			
			try {
				String msg = ((TextMessage) message).getText();
				System.out.println("===Housekeeping=============MESSAGE RECIEVED: " + msg + "===================");
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	@JmsListener(destination = AppConfig.HK_TICKET_UPDATE_QUEUE, containerFactory = "jmsListenerContainerQueue")
	@Qualifier("ticketUpdateQueue")
	public void updateTicketMessage(Message message) {
		
		if (message instanceof ObjectMessage) {
			
			ObjectMessage om = (ObjectMessage)message;
			
			try {
				
				Ticket ticket = (Ticket)om.getObject();
				service.updateTicket(ticket);
				

			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
