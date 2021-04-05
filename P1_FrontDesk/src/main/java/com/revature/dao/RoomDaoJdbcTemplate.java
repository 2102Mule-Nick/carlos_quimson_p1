package com.revature.dao;

import java.sql.PreparedStatement;
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
	public void addRoom(Room room) {
		
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
	public void removeRoom(Room room) {
		String sql = "DELETE FROM rooms WHERE room_number = ?";
		
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, room.getRoomNumber());
			return ps;
		});

	}

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

	@Override
	public List<Room> getAllRooms() {
		String sql = "SELECT * FROM rooms";
		
		List<Room> allRooms = jdbcTemplate.query(sql, roomRowMapper);
		
		return allRooms;
	}



	@Override
	public Room getRoomByRoomNumber(int roomNumber) {
		Room returnRoom;
		
		String sql = "SELECT * FROM rooms WHERE room_number = ?";
			
		List<Room> roomList = jdbcTemplate.query(sql, roomRowMapper, roomNumber);
		
		returnRoom = roomList.get(0);
		
		return returnRoom;
	}
	
	@Override //Using JMS
	public void updateRoomStatus(Room room) {
				
		System.out.println("Attempting to update Room Status in Housekeeping Application via JMS");
		messageSender.housekeepingSend(room);
	}
	
	@Override // Using SOAP
	public void updateRoomOutOfService(Room room) {
		//Setting up call to SOAP Maintenance Service
		UpdateOosImplService updateOos = new UpdateOosImplService();
		UpdateOos update = updateOos.getUpdateOosImplPort();
		
		//creating item for the SOAP Service
		com.revature.ws.Room updateRoom = new com.revature.ws.Room();
		updateRoom.setRoomNumber(room.getRoomNumber());
		updateRoom.setRoomOutOfService(room.isRoomOutOfService());
		
		//checking if room is to be set to Out of Service
		if (room.isRoomOutOfService()) {
			update.roomOutofService(updateRoom);
		} else {
			update.roomInService(updateRoom);
		}
	}
	
//	@Override //copy this to front desk and housekeeping application
//	public void updateRoomStatus(Room room) {
//		messageSender.housekeepingSend(room);
//		
//		/**************************************************************
//		 * code that is in the Housekeeping Application. just use a JMS sender
//		String sql = "UPDATE rooms SET room_status = ? WHERE room_number = ?";
//		
//		jdbcTemplate.update( connection -> {
//			PreparedStatement ps = connection.prepareStatement(sql);
//			ps.setString(1, room.getRoomStatus());
//			ps.setInt(2, room.getRoomNumber());
//			return ps;
//		});
//		*/
	
	
//	@Override // copy this to maintenance application
//	public void updateRoomOutOfService(Room room) {
//		String sql = "UPDATE rooms SET room_out_of_service = ? WHERE room_number = ?";
//		
//		Room updateRoom = this.getRoomByRoomNumber(room.getRoomNumber());
//		
//		jdbcTemplate.update( connection -> {
//			PreparedStatement ps = connection.prepareStatement(sql);
//			ps.setBoolean(1, room.isRoomOutOfService());
//			ps.setInt(2, updateRoom.getRoomNumber());
//			return ps;
//		});
//	}
//
//	}

}
