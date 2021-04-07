package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.pojo.Room;

public interface RoomDao {
	
	/*
	public void addRoom(Room room);
	
	public void removeRoom(Room room);
	
	public void updateRoomOccupied(Room room);
	
	public void updateRoomOutOfService(Room room); -> use SOAP to get this from the maintenance
	
	public void updateRoom(Room room);
	
	*/
	
	public Room getRoomByRoomNumber(int roomNumber);
	
	public void updateRoomStatus(Room room) throws SQLException;
	
	public List<Room> getAllRooms();

}
