package com.revature.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.revature.pojo.Ticket;

public class TicketRowMapper implements RowMapper<Ticket> {

	private TicketExtractor ticketExtractor;
	
	@Autowired	
	public void setTicketExtractor(TicketExtractor ticketExtractor) {
		this.ticketExtractor = ticketExtractor;
	}



	@Override
	public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return ticketExtractor.extractData(rs);
	}

}
