package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.TicketDao;
import com.revature.pojo.Ticket;

@Service
public class TicketServiceImpl implements TicketService {

	private TicketDao ticketDao;
	
	@Autowired
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	@Override
	public Ticket createTicket(Ticket ticket) {

		return ticketDao.createTicket(ticket);
	}

	@Override
	public void updateTicket(Ticket ticket) {
		
		ticketDao.updateTicket(ticket);

	}

}
