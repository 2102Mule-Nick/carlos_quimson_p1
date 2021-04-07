package com.revature.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.revature.dao.mapper.RoomRowMapper;
import com.revature.pojo.Room;

@Repository
public class RoomDaoJdbcTemplate implements RoomDao { //Maintenance application

	private JdbcTemplate jdbcTemplate;
	
	private RoomRowMapper roomRowMapper;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setRoomRowMapper(RoomRowMapper roomRowMapper) {
		this.roomRowMapper = roomRowMapper;
	}
	
	@Override // copy this to maintenance application
	public void updateRoomOutOfService(Room room) {
		String sql = "UPDATE rooms SET room_out_of_service = ? WHERE room_number = ?";
		
		//Room updateRoom = this.getRoomByRoomNumber(room.getRoomNumber());
		
		jdbcTemplate.update( connection -> {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setBoolean(1, room.isRoomOutOfService());
			ps.setInt(2, room.getRoomNumber());
			return ps;
		});
	}
	
	@Override
	public List<Room> getAllRooms() {
		String sql = "SELECT * FROM rooms";
		
		List<Room> allRooms = jdbcTemplate.query(sql, roomRowMapper);
		
		return allRooms;
	}
	
	@Override
	public Room getRoomByRoomNumber(int roomNumber) throws IllegalArgumentException {
		Room returnRoom;
		
		String sql = "SELECT * FROM rooms WHERE room_number = ?";
		
		List<Room> roomList = jdbcTemplate.query(sql, roomRowMapper, roomNumber);
		
		if (roomList.size() == 0) {
			throw new IllegalArgumentException();
		}
		
		returnRoom = roomList.get(0);
		
		return returnRoom;
	}
	



}
