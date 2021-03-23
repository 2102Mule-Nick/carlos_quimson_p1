package com.revature.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.pojo.Employee;
import com.revature.service.AuthService;

public class LoginMenu implements Menu {

	private Logger log = Logger.getRootLogger();
	
	private Scanner scan;
	
	private AuthService authService;
	
	private Menu nextMenu;
	
	private Menu optionsMenu;
	
	@Override
	public void displayOptions() {
		
		System.out.println("Manager Login");
		System.out.println("Enter Employee ID: ");
		int employeeId = Integer.parseInt(scan.nextLine());
		
		System.out.println("Enter password: ");
		String password = scan.nextLine();

		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setPassword(password);
		
		try {
			// if password is valid, employee gets returned and assigned
			employee = authService.authenticateEmployee(employee);
			
			// change nextMenu;
			// pass user to the nextMenu
			//nextMenu = optionsMenu;
			
			
		} catch(Exception e) {
			System.out.println("Incorrect Employee Login. Try again");
			log.error("User entered incorrect information, e");
			nextMenu = this;
		}
	}

	@Override
	public Menu previousMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scanner getScanner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setScanner(Scanner scan) {
		
		this.scan = scan;
	}

	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		return nextMenu;
	}

}
