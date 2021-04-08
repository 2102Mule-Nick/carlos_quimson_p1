package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.pojo.Room;

public interface RoomDao {
	
	public Room getRoomByRoomNumber(int roomNumber);
	
	public void addRoom(Room room) throws SQLException;
	
	public void removeRoom(int roomNumber) throws IllegalArgumentException;
	
	public void updateRoom(Room room) throws IllegalArgumentException;
	
//	public void updateRoomStatus(Room room);
	
//	public void updateRoomOccupied(Room room);
	
//	public void updateRoomOutOfService(Room room);
	
	public List<Room> getAllRooms();

}
