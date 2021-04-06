package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dao.RoomDao;
import com.revature.pojo.Room;

@RestController
public class FrontDeskController {
	private RoomDao roomDao;

	@Autowired
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}
	
	@PutMapping("/room")
	@ResponseBody
	public void updateRoomOccupied(@RequestBody Room room) {
		
		roomDao.updateRoomOccupied(room);
		
		System.out.println("Front Desk Application: Updating Room Occupied");
	}
	
	@GetMapping("/room")
	@ResponseBody
	public List<Room> getAllRooms(){
		
		List<Room> roomList = roomDao.getAllRooms();
		
		return roomList;
	}
	
	@GetMapping("/test")
	@ResponseBody
	public String example() {
		return "working";
	}
}
