package com.revature.dao;

import java.util.List;

import com.revature.pojo.Ticket;

public interface TicketDao {

	public void createTicket(Ticket ticket);
	
	public void updateTicket(Ticket ticket);
	
	public List<Ticket> getAllTickets();
	
	public Ticket getTicketByNumber(int ticketNumber);
	
	
}
