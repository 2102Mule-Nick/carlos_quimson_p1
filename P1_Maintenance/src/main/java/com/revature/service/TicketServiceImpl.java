package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.TicketDao;
import com.revature.messaging.JmsMessageSender;
import com.revature.pojo.Ticket;

@Service
public class TicketServiceImpl implements TicketService {

	private JmsMessageSender messageSender;
	
	private TicketDao ticketDao;
	
	@Autowired
	public void setMessageSender(JmsMessageSender messageSender) {
		this.messageSender = messageSender;
	}
	
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
		
		try {
			ticketDao.updateTicket(ticket);
			messageSender.resolvedTopicSend("Maintenance Application: \nTicket #" + ticket.getTicketNumber() + " has been resolved");
		} catch (IllegalArgumentException e) {
			messageSender.errorTopicSend("Maintenance Application: \n Error: Unable to find maintenance ticket #" + ticket.getTicketNumber());
		}

	}

}
