package com.revature.pojo;

public class Room {
	
	private int roomNumber;
	
	private String roomType;
	
	private String roomStatus;
	
	private boolean roomOccupied;

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
	
	

}
