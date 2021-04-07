package com.revature.service;

import com.revature.pojo.Room;
import com.revature.pojo.Ticket;

public interface CheckService {

	public void checkIn(Room room);
	
	public void checkOut(Room room);
	
	public void changeRoomStatus(Room room);
	
	public void changeRoomOos(Room room);
	
	public void sendMaintenance(Ticket ticket);
	
	public void sendHousekeeping(Ticket ticket);
	
}