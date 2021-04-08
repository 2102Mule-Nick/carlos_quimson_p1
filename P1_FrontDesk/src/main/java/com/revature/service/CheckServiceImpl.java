package com.revature.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.RoomDao;
import com.revature.dao.TicketDao;
import com.revature.messaging.JmsMessageSender;
import com.revature.pojo.Room;
import com.revature.pojo.Ticket;
import com.revature.ws.UpdateOos;
import com.revature.ws.UpdateOosImplService;
import com.revature.ws.UpdateTicket;
import com.revature.ws.UpdateTicketImplService;

@Service
public class CheckServiceImpl implements CheckService {

	private JmsMessageSender messageSender;
	
	private RoomDao roomDao;
	
	private TicketDao ticketDao;
	
	@Autowired
	public void setMessageSender(JmsMessageSender messageSender) {
		this.messageSender = messageSender;
	}

	@Autowired
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	@Autowired
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	@Override
	@Transactional
	public void checkIn(Room room) {
		
		/* Occupied Status to True
		 * HK to dirty
		 * 
		 */
		room.setRoomOccupied(true);
		room.setRoomStatus("Dirty");
		try {
			roomDao.updateRoomOccupied(room);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		messageSender.roomStatusSend(room);
		
	}

	@Override
	@Transactional
	public void checkOut(Room room) {
		// Occupied Status to false
		room.setRoomOccupied(false);
		room.setRoomStatus("Dirty");
		
		try {
			roomDao.updateRoomOccupied(room);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		messageSender.roomStatusSend(room);
	}

	@Override
	@Transactional
	public void sendMaintenance(Ticket ticket) {
		// TODO Auto-generated method stub
		Ticket newTicket = ticketDao.createTicket(ticket);
		
		messageSender.maintenanceTicketSend(newTicket);
	}

	@Override
	@Transactional
	public void sendHousekeeping(Ticket ticket) {
		// TODO Auto-generated method stub
		Ticket newTicket = ticketDao.createTicket(ticket);
		
		messageSender.housekeepingTicketSend(newTicket);
	}

	@Override
	public void changeRoomStatus(Room room) {
		// TODO Auto-generated method stub
		
		messageSender.roomStatusSend(room);
	}

	@Override
	public void changeRoomOos(Room room) {
		// USE SOAP Service for maintenance
//		System.out.println("Room Number: " + room.getRoomNumber() + " Out of Service: " + room.isRoomOutOfService());
		
		UpdateOosImplService updateOos = new UpdateOosImplService();
		UpdateOos update = updateOos.getUpdateOosImplPort();
		
		//creating item for the SOAP Service
		com.revature.ws.Room updateRoom = new com.revature.ws.Room();
		updateRoom.setRoomNumber(room.getRoomNumber());
		updateRoom.setRoomOutOfService(room.isRoomOutOfService());
		
//		System.out.println("Update Room Number: " + updateRoom.getRoomNumber() + " Out of Service: " + updateRoom.isRoomOutOfService());
		
		update.changeOutofService(updateRoom);
		
	}

	@Override
	public void updateHousekeepingTicket(Ticket ticket) {

		messageSender.housekeepingTicketUpdate(ticket);
	}

	@Override
	public void updateMaintenanceTicket(Ticket ticket) {
		//Using maintenance app via SOAP
		
		//System.out.println("ticket number: " + ticket.getTicketNumber());
		
		UpdateTicketImplService updateTicket = new UpdateTicketImplService();
		UpdateTicket update = updateTicket.getUpdateTicketImplPort();
		
		com.revature.ws.Ticket newTicket = new com.revature.ws.Ticket();
		newTicket.setDepartment(ticket.getDepartment());
		newTicket.setRequest(ticket.getRequest());
		newTicket.setResolved(ticket.isResolved());
		newTicket.setRoomNumber(ticket.getRoomNumber());
		newTicket.setTicketNumber(ticket.getTicketNumber());
		
		update.updateTicket(newTicket);
		
	}

}
