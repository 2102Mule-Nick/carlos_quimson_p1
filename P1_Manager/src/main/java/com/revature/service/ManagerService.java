package com.revature.service;

import com.revature.pojo.Room;
import com.revature.pojo.Ticket;

public interface ManagerService {

	
	public void addRoom(Room room);
	
	public void removeRoom(int roomNumber);
	
	public void updateRoom(Room room);
	
	//copied from FD CheckService
	
	public void checkIn(Room room);
	
	public void checkOut(Room room);
	
	public void changeRoomStatus(Room room);
	
	public void changeRoomOos(Room room);
	
	public void sendMaintenance(Ticket ticket);
	
	public void sendHousekeeping(Ticket ticket);
	
	public void updateHousekeepingTicket(Ticket ticket);
	
	public void updateMaintenanceTicket(Ticket ticket);
}
