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
import com.revature.dao.RoomDao;
import com.revature.dao.RoomDaoJdbcTemplate;
import com.revature.dao.TicketDaoJDBCTemplate;
import com.revature.pojo.Room;
import com.revature.pojo.Ticket;

@Component
public class JmsMessageListener implements MessageListener{

	RoomDaoJdbcTemplate roomDao;
	
	TicketDaoJDBCTemplate ticketDao;
	
	@Autowired	
	public void setTicketDao(TicketDaoJDBCTemplate ticketDao) {
		this.ticketDao = ticketDao;
	}

	@Autowired
	public void setRoomDao(RoomDaoJdbcTemplate roomDao) {
		this.roomDao = roomDao;
	}

	@JmsListener(destination = AppConfig.ROOM_STATUS_QUEUE, containerFactory = "jmsListenerContainerQueue")
	public void onMessage(Message message) {
		
		if (message instanceof ObjectMessage) {
			
			ObjectMessage om = (ObjectMessage)message;
			
			try {
				Room room = (Room)om.getObject();
				roomDao.updateRoomStatus(room);
				System.out.println("Message Received: Updating room");
				
				
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
	
//	@JmsListener(destination = AppConfig.HOUSEKEEPING_TICKET_TOPIC)
//	public void ticketMessage(Message message) {
//		
//		if (message instanceof ObjectMessage) {
//			
//			ObjectMessage om = (ObjectMessage)message;
//			
//			try {
//				System.out.println("Housekeeping ticket topic: ");
//				Ticket ticket = (Ticket)om.getObject();
//				ticketDao.getTicketByNumber(ticket.getTicketNumber());
//				System.out.println("New Ticket Received");
//			} catch (JMSException e) {
//				e.printStackTrace();
//			}
//		}
//		
//	}

}
