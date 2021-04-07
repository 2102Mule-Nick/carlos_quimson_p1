package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.pojo.Room;

public interface RoomDao {
	
	public Room getRoomByRoomNumber(int roomNumber);
	
//	public void updateRoomStatus(Room room);
	
	public void updateRoomOccupied(Room room) throws SQLException;
	
//	public void updateRoomOutOfService(Room room);
	
	public List<Room> getAllRooms();
	
//	public void addRoom(Room room);
//	
//	public void removeRoom(Room room);
//	
//	public void updateRoom(Room room);
	

}
