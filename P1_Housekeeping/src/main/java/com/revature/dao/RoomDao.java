package com.revature.dao;

import java.util.List;

import com.revature.pojo.Room;

public interface RoomDao {
	
	/*
	public void addRoom(Room room);
	
	public void removeRoom(Room room);
	
	public void updateRoomOccupied(Room room);
	
	public void updateRoomOutOfService(Room room); -> use SOAP to get this from the maintenance
	
	*/
	
	public void updateRoom(Room room);
	
	public void updateRoomStatus(Room room);
	
	public List<Room> getAllRooms();

}