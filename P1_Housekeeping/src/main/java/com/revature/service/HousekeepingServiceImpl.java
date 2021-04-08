package com.revature.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.RoomDao;
import com.revature.dao.TicketDao;
import com.revature.messaging.JmsMessageSender;
import com.revature.pojo.Room;
import com.revature.pojo.Ticket;

@Service
public class HousekeepingServiceImpl implements HousekeepingService {

	private TicketDao ticketDao;
	
	private RoomDao roomDao;
	
	private JmsMessageSender messageSender;
	
	@Autowired	
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	@Autowired
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	@Autowired
	public void setMessageSender(JmsMessageSender messageSender) {
		this.messageSender = messageSender;
	}

	@Override
	public Ticket createTicket(Ticket ticket) {
		
		return ticketDao.createTicket(ticket);
	}

	@Override
	public void updateTicket(Ticket ticket) {
		
		try {
			ticketDao.updateTicket(ticket);
			messageSender.resolvedTopicSend("Housekeeping Application: Ticket #: " + ticket.getTicketNumber() + " has been updated");
			//System.out.println("Updating ticket Number: " + ticket.getTicketNumber());
		} catch (IllegalArgumentException e) {
			messageSender.errorTopicSend("Housekeeping Application: \n Unable to update ticket #: " + ticket.getTicketNumber() + "\nStack Trace: \n" + e.toString());
		} catch (Exception e) {
			messageSender.errorTopicSend("Housekeeping Application: \n Unable to update ticket #: " + ticket.getTicketNumber() + "\nStack Trace: \n" + e.toString());
		}
	}

	@Override
	public void updateRoomStatus(Room room) {
		
		try {
			roomDao.updateRoomStatus(room);
			System.out.println("Sysout: Message Received: Updating room " + room.getRoomNumber());
		} catch (SQLException | IllegalArgumentException e) {
			messageSender.errorTopicSend("Housekeeping Application: \n Unable to update Room Status for room: " + room.getRoomNumber() + "\nStack Trace: \n" + e.toString());
			//e.printStackTrace();
		}

	}

}
