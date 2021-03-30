package com.revature.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.revature.pojo.Employee;

@Component
public class EmployeeExtractor implements ResultSetExtractor<Employee> {

	@Override
	public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		Employee newEmployee = new Employee();
		
		newEmployee.setEmployeeId(rs.getInt("employee_id"));
		newEmployee.setFirstName(rs.getString("first_name"));
		newEmployee.setLastName(rs.getString("last_name"));
		newEmployee.setPassword(rs.getString("pass_word"));
		newEmployee.setDepartment(rs.getString("department"));
		
		return newEmployee;
	}

}
