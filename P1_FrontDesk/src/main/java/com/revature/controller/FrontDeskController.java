package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dao.RoomDao;
import com.revature.dao.TicketDao;
import com.revature.pojo.Room;
import com.revature.pojo.Ticket;
import com.revature.service.CheckService;

@RestController
public class FrontDeskController {

	private RoomDao roomDao;
	
	private TicketDao ticketDao;
	
	private CheckService service;

	@Autowired
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	@Autowired
	public void setService(CheckService service) {
		this.service = service;
	}

	@Autowired
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}
	
	@PutMapping("/room/checkin")
	@ResponseBody
	public void checkIn(@RequestBody Room room) {
		
		service.checkIn(room);
		
		System.out.println("Front Desk Application: Room Checkin");
	}
	
	@GetMapping("/room")
	@ResponseBody
	public List<Room> getAllRooms(){
		
		List<Room> roomList = roomDao.getAllRooms();
		
		return roomList;
	}
	
	@PutMapping("/room/checkout")
	@ResponseBody
	public void checkOut(@RequestBody Room room) {
		service.checkOut(room);
	}
	
	@GetMapping("/ticket")
	@ResponseBody
	public List<Ticket> getAllTicketss(){
		
		List<Ticket> ticketList = ticketDao.getAllTickets();
		
		return ticketList;
	}
	
	@PostMapping("/ticket/maintenance")
	@ResponseBody
	public void maintenanceTicket(@RequestBody Ticket ticket) {
		service.sendMaintenance(ticket);
	}
	
	@PostMapping("/ticket/housekeeping")
	@ResponseBody
	public void housekeepingTicket(@RequestBody Ticket ticket) {
		service.sendHousekeeping(ticket);
	}
	
	@PutMapping("/room/update")
	@ResponseBody
	public void updateRoomStatus(@RequestBody Room room) {
		service.changeRoomStatus(room);
	}
	
	@PutMapping("/room/oos")
	@ResponseBody
	public void updateRoomOos(@RequestBody Room room) {
		System.out.println("Room Number: " + room.getRoomNumber() + " Out of Service: " + room.isRoomOutOfService());
		
		service.changeRoomOos(room);
	}
	
	@GetMapping("/test")
	public String example() {
		return "working";
	}
	
	@PutMapping("/ticket/housekeeping")
	@ResponseBody
	public void housekeepingTicketUpdate(@RequestBody Ticket ticket) {
		service.updateHousekeepingTicket(ticket);
	}
	
	@PutMapping("/ticket/maintenance")
	@ResponseBody
	public void maintenanceTicketUpdate(@RequestBody Ticket ticket) {
		service.updateMaintenanceTicket(ticket);
	}
}
