package com.revature.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.revature.dao.mapper.RoomRowMapper;
import com.revature.messaging.JmsMessageSender;
import com.revature.pojo.Room;
import com.revature.ws.UpdateOos;
import com.revature.ws.UpdateOosImplService;

@Repository
public class RoomDaoJdbcTemplate implements RoomDao {

	private JdbcTemplate jdbcTemplate;
	
	private RoomRowMapper roomRowMapper;
	
	private JmsMessageSender messageSender;
	
	@Autowired
	public void setMessageSender(JmsMessageSender messageSender) {
		this.messageSender = messageSender;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setRoomRowMapper(RoomRowMapper roomRowMapper) {
		this.roomRowMapper = roomRowMapper;
	}

	@Override
	public void addRoom(Room room) throws SQLException {
		
		String sql = "INSERT INTO rooms (room_number, room_type, room_status, room_occupied, room_out_of_service)"
				+ "VALUES (?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, room.getRoomNumber());
			ps.setString(2, room.getRoomType());
			ps.setString(3, room.getRoomStatus());
			ps.setBoolean(4, room.isRoomOccupied());
			ps.setBoolean(5, room.isRoomOutOfService());
			return ps;
		});

	}

	@Override
	public void removeRoom(int roomNumber) throws IllegalArgumentException {
		String sql = "DELETE FROM rooms WHERE room_number = ?";
		
		this.getRoomByRoomNumber(roomNumber); // checks if room is in db
		
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, roomNumber);
			return ps;
		});

	}

	@Override
	public void updateRoom(Room room) throws IllegalArgumentException {
		String sql = "UPDATE rooms SET room_type = ? WHERE room_number = ?";
		
		this.getRoomByRoomNumber(room.getRoomNumber()); // checks if room is in db
		
		jdbcTemplate.update( connection -> {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, room.getRoomType());
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
