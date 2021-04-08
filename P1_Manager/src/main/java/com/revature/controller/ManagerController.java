package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.revature.service.ManagerService;

@RestController
public class ManagerController {

	private ManagerService managerService;
	
	private RoomDao roomDao;
	
	private TicketDao ticketDao;

	@Autowired
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	@Autowired
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	@Autowired
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	@PostMapping("/room")
	@ResponseBody
	public void addRoom(@RequestBody Room room) {
		managerService.addRoom(room);
	}
	
	@DeleteMapping("/room")
	@ResponseBody
	public void removeRoom(@RequestBody Room room) {
		managerService.removeRoom(room.getRoomNumber());
	}
	
	@PutMapping("/room")
	@ResponseBody
	public void updateRoom(@RequestBody Room room) {
		managerService.updateRoom(room);
	}
		
	@PutMapping("/room/checkin")
	@ResponseBody
	public void checkIn(@RequestBody Room room) {
		managerService.checkIn(room);
	}
	
	@PutMapping("/room/checkout")
	@ResponseBody
	public void checkOut(@RequestBody Room room) {
		managerService.checkOut(room);
	}
	
	@PutMapping("/room/oos")
	@ResponseBody
	public void changeRoomOos(@RequestBody Room room) {
		managerService.changeRoomOos(room);
	}
	
	@PutMapping("/room/status")
	@ResponseBody
	public void changeRoomStatus(@RequestBody Room room) {
		managerService.changeRoomStatus(room);
	}
	
	@PostMapping("/ticket/maintenance")
	@ResponseBody
	public void sendMaintenance(@RequestBody Ticket ticket) {
		managerService.sendMaintenance(ticket);
	}
	
	@PostMapping("/ticket/housekeeping")
	@ResponseBody
	public void sendHousekeeping(@RequestBody Ticket ticket) {
		managerService.sendHousekeeping(ticket);
	}
	
	@PutMapping("/ticket/maintenance")
	@ResponseBody
	public void maintenanceTicketUpdate(@RequestBody Ticket ticket) {
		managerService.updateMaintenanceTicket(ticket);
	}
	
	@PutMapping("/ticket/housekeeping")
	@ResponseBody
	public void housekeepingTicketUpdate(@RequestBody Ticket ticket) {
		managerService.updateHousekeepingTicket(ticket);
	}
	
	@GetMapping("/room")
	@ResponseBody
	public List<Room> getAllRooms() {
		return roomDao.getAllRooms();
	}
	
	@GetMapping("/ticket")
	@ResponseBody
	public List<Ticket> getAllTickets() {
		return ticketDao.getAllTickets();
	}
	
}
