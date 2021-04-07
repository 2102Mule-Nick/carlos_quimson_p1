package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.RoomDao;
import com.revature.pojo.Room;

@Service
public class UpdateOosServiceImpl implements UpdateOosService {

	RoomDao roomDao;
	
	@Autowired
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	@Override
	public void changeOutofService(Room room) {
		Room updateRoom = new Room();
		updateRoom.setRoomNumber(room.getRoomNumber());
		updateRoom.setRoomOutOfService(room.isRoomOutOfService());
		
		roomDao.updateRoomOutOfService(updateRoom); //only passes room number and a hard coded true value for outofservice
	}

//	@Override
//	public void roomInService(Room room) {
//		Room updateRoom = new Room();
//		updateRoom.setRoomNumber(room.getRoomNumber());
//		updateRoom.setRoomOutOfService(false);
//		
//		roomDao.updateRoomOutOfService(updateRoom); //only passes room number and a hard coded false value for outofservice
//
//	}

}
