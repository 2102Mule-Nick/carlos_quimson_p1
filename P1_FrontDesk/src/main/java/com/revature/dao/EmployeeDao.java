package com.revature.dao;

import java.util.List;

import com.revature.pojo.Employee;

public interface EmployeeDao {

	public Employee addEmployee(Employee employee);
	
	public Employee getEmployeeByEmployeeId(int employeeId);
	
	public List<Employee> getAllEmployee();
	
	public void updateEmployee(Employee employee);
	
	public void removeEmployee(Employee employee);
	
}
