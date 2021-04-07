package com.revature.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.pojo.Ticket;
import com.revature.service.TicketService;

@Service
public class UpdateTicketImpl implements UpdateTicket {

	TicketService ticketService;
	
	@Autowired
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@Override
	public void updateTicket(Ticket ticket) {
		ticketService.updateTicket(ticket);

	}

}
