package com.revature.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.revature.pojo.Ticket;

@WebService
public interface UpdateTicket {

	@WebMethod
	public void updateTicket(Ticket ticket);
	
}
