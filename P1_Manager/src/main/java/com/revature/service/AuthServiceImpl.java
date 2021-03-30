package com.revature.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.dao.EmployeeDao;
import com.revature.pojo.Employee;

@Component
public class AuthServiceImpl implements AuthService {

	private Logger log = Logger.getRootLogger();
	
	private EmployeeDao employeeDao;
	
	@Override
	public boolean existingEmployee(Employee employee) {
		
		try {
			if (employeeDao.getEmployeeByEmployeeId(employee.getEmployeeId()) != null) {
				return true;
			}
		} catch (Exception e) {
			log.warn("Employee not found");
			return false;
		}
	
		return false;
	}

	@Override
	public Employee authenticateEmployee(Employee employee) {
		log.info("AuthServiceImpl.authenticateEmployee method called");
		
		// gets employee from database via employeeId
		Employee existingEmployee = employeeDao.getEmployeeByEmployeeId(employee.getEmployeeId());
		
		// if password is matched, return the employee object
		if (existingEmployee.getPassword().equals(employee.getPassword())) {
			return existingEmployee;
		}
		throw new IllegalArgumentException();
	}

	@Autowired
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public AuthServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
