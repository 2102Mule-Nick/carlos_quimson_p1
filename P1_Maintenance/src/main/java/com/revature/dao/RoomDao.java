package com.revature.dao;

import java.util.List;

import com.revature.pojo.Room;

public interface RoomDao {
	
	public void updateRoomOutOfService(Room room) throws IllegalArgumentException;
	
	public List<Room> getAllRooms();
	
	public Room getRoomByRoomNumber(int roomNumber);
	
	/********************
	public void addRoom(Room room);
	
	public void removeRoom(Room room);
	
	public void updateRoom(Room room);
	
	public void updateRoomStatus(Room room);
	
	public void updateRoomOccupied(Room room);
		**************************/


}
