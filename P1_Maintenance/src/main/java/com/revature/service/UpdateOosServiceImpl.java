package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.RoomDao;
import com.revature.messaging.JmsMessageSender;
import com.revature.pojo.Room;

@Service
public class UpdateOosServiceImpl implements UpdateOosService {

	RoomDao roomDao;
	
	JmsMessageSender messageSender;
	
	@Autowired
	public void setMessageSender(JmsMessageSender messageSender) {
		this.messageSender = messageSender;
	}

	@Autowired
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	@Override
	public void changeOutofService(Room room) {
		
		Room updateRoom = roomDao.getRoomByRoomNumber(room.getRoomNumber());
		
		if (updateRoom.isRoomOccupied() == false) {
		
		
			try {
				roomDao.updateRoomOutOfService(room); 
			} catch (IllegalArgumentException e) {
				// send message to Error topic
				messageSender.errorTopicSend("Maintenance Application: \nUnable to update Room OUT OF SERVICE Status for room: " + room.getRoomNumber() + "\nStack Trace: \n" + e.toString());
			}
		} else {
			messageSender.errorTopicSend("Maintenance Application:\nUnable to put room " + updateRoom.getRoomNumber() + " because it is currently occupied");
		}
	}



}
