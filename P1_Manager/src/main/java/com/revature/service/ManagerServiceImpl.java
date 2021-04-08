package com.revature.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.RoomDao;
import com.revature.pojo.Room;
import com.revature.pojo.Ticket;

@Service
public class ManagerServiceImpl implements ManagerService {

	private RoomDao roomDao;
	
	private FdServiceFinder serviceFinder;
	
	@Autowired
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	@Autowired
	public void setServiceFinder(FdServiceFinder serviceFinder) {
		this.serviceFinder = serviceFinder;
	}

	@Override
	public void addRoom(Room room) {
		try {
			roomDao.addRoom(room);
		} catch (SQLException | IllegalArgumentException e) {
			//maybe send message to error QUeue or add to log
			e.printStackTrace();
		}

	}

	@Override
	public void removeRoom(int roomNumber) {
		try {
			roomDao.removeRoom(roomNumber);
		} catch (IllegalArgumentException e) {
			//maybe send message to error QUeue or add to log
			e.printStackTrace();
		}

	}

	@Override
	public void updateRoom(Room room) {
		try {
			roomDao.updateRoom(room);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void checkIn(Room room) {

		serviceFinder.fdCheckIn(room);

	}

	@Override
	public void checkOut(Room room) {
		
		serviceFinder.fdCheckOut(room);

	}

	@Override
	public void changeRoomStatus(Room room) {

		serviceFinder.updateRoomStatus(room);

	}

	@Override
	public void changeRoomOos(Room room) {
		
		serviceFinder.updateOosStatus(room);

	}

	@Override
	public void sendMaintenance(Ticket ticket) {

		serviceFinder.createMaintenanceTicket(ticket);

	}

	@Override
	public void sendHousekeeping(Ticket ticket) {

		serviceFinder.createHousekeepingTicket(ticket);

	}

}
