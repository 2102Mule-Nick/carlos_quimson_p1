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
		
		ticketDao.updateTicket(ticket);

	}

	@Override
	public void updateRoomStatus(Room room) {
		
		try {
			roomDao.updateRoomStatus(room);
			System.out.println("Message Received: Updating room " + room.getRoomNumber());
		} catch (SQLException | IllegalArgumentException e) {
			messageSender.errorTopicSend("Housekeeping Application: \n Unable to update Room Status for room: " + room.getRoomNumber() + "\nStack Trace: \n" + e.toString());
			//e.printStackTrace();
		}

	}

}
