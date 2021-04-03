package com.revature.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.revature.pojo.Room;

@Component
public class RoomExtractor implements ResultSetExtractor<Room> {

	@Override
	public Room extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		Room newRoom = new Room();
		
		newRoom.setRoomNumber(rs.getInt("room_number"));
		newRoom.setRoomStatus(rs.getString("room_status"));
		newRoom.setRoomType(rs.getString("room_type"));
		newRoom.setRoomOccupied(rs.getBoolean("room_occupied"));
		
		return newRoom;
	}

}
