package com.revature.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.revature.pojo.Ticket;

@Component
public class TicketExtractor implements ResultSetExtractor<Ticket> {

	@Override
	public Ticket extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		Ticket newTicket = new Ticket();
		
		newTicket.setTicketNumber(rs.getInt("ticket_number"));
		newTicket.setRoomNumber(rs.getInt("room_number"));
		newTicket.setDepartment(rs.getString("department"));
		newTicket.setRequest(rs.getString("request"));
		newTicket.setResolved(rs.getBoolean("resolved"));
		
		return newTicket;
	}

}
