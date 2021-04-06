package com.revature;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.config.AppConfig;
import com.revature.dao.EmployeeDaoJDBCTemplate;
import com.revature.dao.RoomDaoJdbcTemplate;
import com.revature.dao.TicketDaoJDBCTemplate;
import com.revature.messaging.JmsMessageSender;
import com.revature.pojo.Employee;
import com.revature.pojo.Room;
import com.revature.pojo.Ticket;

public class TestDriver {

public static void main(String[] args) {
		
		String command = null;
		
		Scanner scan = new Scanner(System.in);
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		JmsMessageSender messageSender = appContext.getBean("jmsMessageSender", JmsMessageSender.class);
		
		RoomDaoJdbcTemplate roomDao = appContext.getBean(RoomDaoJdbcTemplate.class);
		
		TicketDaoJDBCTemplate ticketDao = appContext.getBean(TicketDaoJDBCTemplate.class);
		
		//Creating a ticket using JMS
		System.out.println("Attempting to add ticket");
		Ticket newTicket = new Ticket();
		newTicket.setDepartment("Housekeeping");
		newTicket.setRoomNumber(101);
		newTicket.setRequest("Plunger");
		
		Ticket rTicket = new Ticket();
		
		rTicket = ticketDao.createTicket(newTicket);
		
		newTicket.setTicketNumber(rTicket.getTicketNumber());
		
		messageSender.housekeepingTicketSend(newTicket);
		
		System.out.println("New Ticket sent");
		
		/*
		 * Attempting to create a ticket
		 * 
		 */
//		System.out.println("Attempting to add ticket");
//		Ticket newTicket = new Ticket();
//		newTicket.setDepartment("Housekeeping");
//		newTicket.setRoomNumber(101);
//		newTicket.setRequest("Requests new towels");
//		
//		Ticket rTicket = new Ticket();
//		
//		rTicket = ticketDao.createTicket(newTicket);
//		
//		newTicket.setTicketNumber(rTicket.getTicketNumber());
//		
//		System.out.println("New Ticket entered: " + newTicket.getTicketNumber() + " Request: " + newTicket.getRequest());
		
		/*
		 * Attempting to resolve Ticket
		 * 
		 */
		
//		Ticket resolveTicket = new Ticket();
//		resolveTicket.setRequest("Towels given");
//		resolveTicket.setTicketNumber(1);
//		resolveTicket.setResolved(true);
//		
//		ticketDao.updateTicket(resolveTicket);
//		System.out.println("Ticket updated: " + resolveTicket.getTicketNumber() + " Request: " + resolveTicket.getRequest());
		
		/**********
		 * Testing JMS
		 * 
		messageSender.simpleSend("Just testing how to use JMS");
		
		System.out.println("Message sent to Housekeeping");
		*/
		
		
		
		//testing adding a room
		
//		Room room = new Room();
//		
//		room.setRoomNumber(201);
//		room.setRoomStatus("Dirty");
//		room.setRoomType("NKK");
//		room.setRoomOccupied(false);
//		room.setRoomOutOfService(false);
//		
//		roomDao.addRoom(room);
		
		
		
		/***********************************************
		 * Testing using SOAP via the updateOos
		 */
//		System.out.println("Attempting to Update OOS");
//		Room room = new Room();
//		room.setRoomNumber(101);
//		room.setRoomOutOfService(false);
//		
//		roomDao.updateRoomOutOfService(room);
//		System.out.println("Room out of Service updated");
		

//**********************************************************************
		// Testing setting a roomStatus via JMS
//		Room room = new Room();
//		
//		room.setRoomNumber(101);
//		room.setRoomStatus("Clean");
//		
//		
//		System.out.println("Attempting to update Room Status in Housekeeping Application via JMS");
//		messageSender.housekeepingSend(room);
		
		// testing adding an employee
		
//		EmployeeDaoJDBCTemplate employeeDao = appContext.getBean(EmployeeDaoJDBCTemplate.class);
//		
//		Employee employee = new Employee();
//		
//		employee.setFirstName("mike");
//		employee.setLastName("test");
//		employee.setDepartment("Manager");
//		employee.setPassword("1234");
//		
//		Employee returnEmployee = employeeDao.addEmployee(employee);
//		
//		employee.setEmployeeId(returnEmployee.getEmployeeId());
//		
//		System.out.println("Auto-generated Employee ID: " + employee.getEmployeeId());
		
	}
}
