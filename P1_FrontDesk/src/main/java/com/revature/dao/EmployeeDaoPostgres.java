package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.pojo.Employee;
import com.revature.util.ConnectionFactory;

public class EmployeeDaoPostgres implements EmployeeDao {

	private Logger log = Logger.getRootLogger();
	
	Connection connection = null;
	
	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		connection = ConnectionFactory.getConnection();
		
		String stmt = "INSERT INTO employees (first_name, last_name, passcode, department)";
		stmt += "VALUES (?, ?, ?, ?)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = connection.prepareStatement(stmt);
			
			pstmt.setString(1, employee.getFirstName());
			pstmt.setString(2,  employee.getLastName());
			pstmt.setString(3, employee.getPassword());
			pstmt.setString(4,  employee.getDepartment());
			
			pstmt.execute();
			log.info("Employee added to database successfully");
			
		} catch (SQLException e) {
			log.error("Error Adding user to database", e);
		}

	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		log.info("EmployeeDaoPostgres.getEmployeeByEmployeeId method called");
		
		connection = ConnectionFactory.getConnection();
		
		String stmt = "SELECT * FROM employees WHERE employee_id = ?";
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		try {
			pstmt = connection.prepareStatement(stmt);
			pstmt.setInt(1, employeeId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(rs.getInt("employee_id"));
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setDepartment(rs.getString("department"));
				return employee;
			}
		} catch (SQLException e) {
			log.error("Error returning employee from DB", e);
		}
		
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

		log.info("EmployeeDaoPostgres.updateEmployee method called");
		
		connection = ConnectionFactory.getConnection();
		
		String stmt = "UPDATE employees SET first_name = ?, last_name = ?, passcode = ?, department = ?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = connection.prepareStatement(stmt);
			
			pstmt.setString(1, employee.getFirstName());
			pstmt.setString(2, employee.getLastName());
			pstmt.setString(3, employee.getPassword());
			pstmt.setString(4, employee.getDepartment());
			
			pstmt.executeUpdate();
			log.info("User Successfully Updated");
		} catch (SQLException e) {
			log.error("Error updating user in database", e);
		}
		
	}

	@Override
	public void removeEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

}
