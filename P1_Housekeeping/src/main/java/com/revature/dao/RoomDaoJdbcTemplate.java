package com.revature.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.revature.dao.mapper.RoomRowMapper;
import com.revature.pojo.Room;

@Repository
public class RoomDaoJdbcTemplate implements RoomDao {

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
	
	@Override
	public Room getRoomByRoomNumber(int roomNumber) throws IllegalArgumentException {
		Room returnRoom;
		
		String sql = "SELECT * FROM rooms WHERE room_number = ?";
		
		List<Room> roomList = jdbcTemplate.query(sql, roomRowMapper, roomNumber);
		
		if (roomList.size() == 0) {
			throw new IllegalArgumentException("Invalid room number");
		}
		returnRoom = roomList.get(0);
		
		return returnRoom;
	}

	@Override //copy this to front desk and housekeeping application
	public void updateRoomStatus(Room room) throws IllegalArgumentException, SQLException {
		String sql = "UPDATE rooms SET room_status = ? WHERE room_number = ?";
		
		Room updateRoom = this.getRoomByRoomNumber(room.getRoomNumber());
		
		jdbcTemplate.update( connection -> {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, room.getRoomStatus());
			ps.setInt(2, updateRoom.getRoomNumber());
			return ps;
		});

	}

	@Override
	public List<Room> getAllRooms() {
		String sql = "SELECT * FROM rooms";
		
		List<Room> allRooms = jdbcTemplate.query(sql, roomRowMapper);
		
		return allRooms;
	}
	
	
	/***********************************************************************************************
	 * only manager can access this methods
	 * 
	
		@Override
	public void updateRoom(Room room) {
		String sql = "UPDATE rooms SET room_type = ? WHERE room_number = ?";
		
		jdbcTemplate.update( connection -> {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, room.getRoomType());
			ps.setInt(2, room.getRoomNumber());
			return ps;
		});

	}
	
	
	@Override
	public void addRoom(Room room) {
		
		String sql = "INSERT INTO rooms (room_number, room_type, room_status, room_occupied)"
				+ "VALUES (?, ?, ?, ?)";
		
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, room.getRoomNumber());
			ps.setString(2, room.getRoomType());
			ps.setString(3, room.getRoomStatus());
			ps.setBoolean(4, room.isRoomOccupied());
			return ps;
		});

	}

	@Override
	public void removeRoom(Room room) {
		String sql = "DELETE FROM rooms WHERE room_number = ?";
		
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, room.getRoomNumber());
			return ps;
		});

	}
	
	@Override // copy this to front desk application
	public void updateRoomOccupied(Room room) {
		String sql = "UPDATE rooms SET room_occupied = ? WHERE room_number = ?";
		
		jdbcTemplate.update( connection -> {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setBoolean(1, room.isRoomOccupied());
			ps.setInt(2, room.getRoomNumber());
			return ps;
		});

	}
	
	@Override // copy this to maintenance application
	public void updateRoomOutOfService(Room room) {
		String sql = "UPDATE rooms SET room_out_of_service = ? WHERE room_number = ?";
		
		jdbcTemplate.update( connection -> {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setBoolean(1, room.isRoomOutOfService());
			ps.setInt(2, room.getRoomNumber());
			return ps;
		});
	}
	******************************************************************************/

}
