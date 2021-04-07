package com.revature.service;

import com.revature.pojo.Room;
import com.revature.pojo.Ticket;

public interface HousekeepingService {

	public Ticket createTicket(Ticket ticket);
	
	public void updateTicket(Ticket ticket);
	
	public void updateRoomStatus(Room room);
	
}
