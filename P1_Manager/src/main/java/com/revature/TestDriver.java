package com.revature;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.config.AppConfig;
import com.revature.dao.EmployeeDaoJDBCTemplate;
import com.revature.dao.RoomDaoJdbcTemplate;
import com.revature.messaging.JmsMessageSender;
import com.revature.pojo.Employee;
import com.revature.pojo.Room;

public class TestDriver {

public static void main(String[] args) {
		
		String command = null;
		
		Scanner scan = new Scanner(System.in);
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		JmsMessageSender messageSender = appContext.getBean("jmsMessageSender", JmsMessageSender.class);
		
		
		/**********
		 * Testing JMS
		 * 
		messageSender.simpleSend("Just testing how to use JMS");
		
		System.out.println("Message sent to Housekeeping");
		*/
		
		
		
		
		
		/******************
		 * testing adding a room
		 * 
		RoomDaoJdbcTemplate roomDao = appContext.getBean(RoomDaoJdbcTemplate.class);
		
		Room room = new Room();
		
		room.setRoomNumber(101);
		room.setRoomStatus("Dirty");
		room.setRoomType("NKK");
		room.setRoomOccupied(false);
		room.setRoomOutOfService(false);
		
		roomDao.addRoom(room);
		*/
		
		// Testing setting a roomStatus via JMS
		Room room = new Room();
		
		room.setRoomNumber(101);
		room.setRoomStatus("Clean");
		
		
		System.out.println("Attempting to update Room Status in Housekeeping Application via JMS");
		messageSender.housekeepingSend(room);
		
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
