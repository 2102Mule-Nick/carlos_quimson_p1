package com.revature.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.revature.dao.mapper.TicketRowMapper;
import com.revature.pojo.Ticket;

@Repository
public class TicketDaoJDBCTemplate implements TicketDao {
	
	private JdbcTemplate jdbcTemplate;
	
	private TicketRowMapper ticketRowMapper;

	@Autowired
	public void setTicketRowMapper(TicketRowMapper ticketRowMapper) {
		this.ticketRowMapper = ticketRowMapper;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Ticket createTicket(Ticket ticket) {

		String sql = "INSERT INTO tickets (room_number, department, request, resolved)"
				+ "VALUES (?, ?, ?, false)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, ticket.getRoomNumber());
			ps.setString(2, ticket.getDepartment());
			ps.setString(3, ticket.getRequest());
			return ps;
		}, keyHolder);
		
		ticket.setTicketNumber((int) keyHolder.getKeys().get("ticket_number"));
		
		return ticket;
	}

	@Override
	public void updateTicket(Ticket ticket) throws IllegalArgumentException {
		
		
		Ticket updateTicket = this.getTicketByNumber(ticket.getTicketNumber());
		
		String sql = "UPDATE tickets SET request = ?, resolved = ? WHERE ticket_number = ?";
		
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, ticket.getRequest() + "\n" +  updateTicket.getRequest());
			ps.setBoolean(2, ticket.isResolved());
			ps.setInt(3, ticket.getTicketNumber());
			return ps;
		});

	}

	@Override
	public List<Ticket> getAllTickets() {
		
		String sql = "SELECT * FROM tickets";
		
		List<Ticket> allTickets = jdbcTemplate.query(sql, ticketRowMapper);
		
		return allTickets;
	}

	@Override
	public Ticket getTicketByNumber(int ticketNumber) throws IllegalArgumentException {
		
		Ticket returnTicket;
		
		String sql = "SELECT * FROM tickets WHERE ticket_number = ?";
		
		List<Ticket> ticketList = jdbcTemplate.query(sql, ticketRowMapper, ticketNumber);
		
		if (ticketList.size() == 0) {
			throw new IllegalArgumentException();
		}
		
		returnTicket = ticketList.get(0);
		
//		Ticket returnTicket = jdbcTemplate.queryForObject(sql, (rs, ticketRowMapper) -> new Ticket(ticketNumber, rs.getInt("room_number"),
//				rs.getString("department"), rs.getString("request"), rs.getBoolean("resolved")), ticketNumber);
		
		return returnTicket;
	}

}
