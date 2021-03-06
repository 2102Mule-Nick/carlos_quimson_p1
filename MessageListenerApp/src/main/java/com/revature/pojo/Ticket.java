package com.revature.pojo;

import java.io.Serializable;

public class Ticket implements Serializable {

	private int ticketNumber;
	
	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	private int roomNumber;
	
	private String department;
	
	private String request;
	
	private boolean resolved;

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public boolean isResolved() {
		return resolved;
	}

	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticket(int ticketNumber, int roomNumber, String department, String request, boolean resolved) {
		super();
		this.ticketNumber = ticketNumber;
		this.roomNumber = roomNumber;
		this.department = department;
		this.request = request;
		this.resolved = resolved;
	}
	
	
	
}
