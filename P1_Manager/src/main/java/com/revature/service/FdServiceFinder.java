package com.revature.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.pojo.Room;
import com.revature.pojo.Ticket;

@Service
public class FdServiceFinder {
	
	public void fdCheckIn(Room room) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.put("http://localhost:8080/P1_FrontDesk/rest/room/checkin", room, Room.class);
	}
	
	public List<Room> getAllRooms(){
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<Room>> response =  restTemplate.exchange("http://localhost:8080/P1_FrontDesk/rest/room/"
				, HttpMethod.GET, null, new ParameterizedTypeReference<List<Room>>() {});
		
		List<Room> roomList = response.getBody();
		
		return roomList;
	}
	
	public void fdCheckOut(Room room) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.put("http://localhost:8080/P1_FrontDesk/rest/room/checkout", room, Room.class);
	}
	
	public List<Ticket> getAllTickets(){
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<Ticket>> response =  restTemplate.exchange("http://localhost:8080/P1_FrontDesk/rest/ticket/"
				, HttpMethod.GET, null, new ParameterizedTypeReference<List<Ticket>>() {});
		
		List<Ticket> ticketList = response.getBody();
		
		return ticketList;
	}
	
	public void createMaintenanceTicket(Ticket ticket) {
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.postForObject("http://localhost:8080/P1_FrontDesk/rest/ticket/maintenance", ticket,
				Ticket.class);
	}
	
	public void createHousekeepingTicket(Ticket ticket) {
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.postForObject("http://localhost:8080/P1_FrontDesk/rest/ticket/housekeeping", ticket,
				Ticket.class);
	}
	
	public void updateRoomStatus(Room room) {
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.put("http://localhost:8080/P1_FrontDesk/rest/room/update", room, Room.class);
	}
	
	public void updateOosStatus(Room room) {
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.put("http://localhost:8080/P1_FrontDesk/rest/room/oos", room, Room.class);
	}

}
