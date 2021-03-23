package com.revature.service;

import com.revature.pojo.Employee;

public interface AuthService {

	public boolean existingEmployee(Employee employee);
	
	public Employee authenticateEmployee(Employee employee);
	
}
