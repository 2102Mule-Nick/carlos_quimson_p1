package com.revature.pojo;

import java.io.Serializable;

public class Room implements Serializable {
	
	private int roomNumber;
	
	private String roomType;
	
	private String roomStatus;
	
	private boolean roomOccupied;
	
	private boolean roomOutOfService;
	
	public boolean isRoomOutOfService() {
		return roomOutOfService;
	}

	public void setRoomOutOfService(boolean roomOutOfService) {
		this.roomOutOfService = roomOutOfService;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public boolean isRoomOccupied() {
		return roomOccupied;
	}

	public void setRoomOccupied(boolean roomOccupied) {
		this.roomOccupied = roomOccupied;
	}

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(int roomNumber, String roomType, String roomStatus, boolean roomOccupied, boolean roomOutOfService) {
		super();
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.roomStatus = roomStatus;
		this.roomOccupied = roomOccupied;
		this.roomOutOfService = roomOutOfService;
	}
	
	

}
